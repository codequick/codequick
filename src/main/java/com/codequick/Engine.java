package com.codequick;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Properties;

import com.codequick.model.ColumnDef;
import com.codequick.model.TableDef;

public abstract class Engine {

	private String ignoreTablePrefix;
	private String ignoreColumnPrefix;
	private String ignoreWordSeparator;
	private boolean useCamelCase;
	
	private static final String PATH_SEPARATOR = System.getProperty("file.separator");
	
	protected String templatePath;
	protected String exportPath;
	protected String buildPath;
	
	protected String[] tableInfo;
	protected String[] columnInfo;
	
	protected Properties properties;
	
	abstract void saveObject(TableDef tableDef, File file, String fileName);
	
	abstract TableDef parseObject(String fileName);
	
	public static Engine getInstance (Properties properties) {
		
		Engine engine = null;
		String exportFormat = properties.getProperty("exportFormat");
		
    	if (exportFormat.equals("xml")) {
    		engine = XmlEngine.getInstance(properties);
    	} else if (exportFormat.equals("json")) {
    		engine = JsonEngine.getInstance(properties);
    	} else {
    		return null;
    	}
		
    	engine.configDefaults(properties);
    	
		return engine;
		
	}

	protected void configDefaults(Properties properties) {
		
		this.properties = properties;
		
		//get the property value
		templatePath = properties.getProperty("templatePath");
		exportPath = properties.getProperty("exportPath");
		buildPath = properties.getProperty("buildPath");
		
		ignoreTablePrefix = properties.getProperty("ignoreTablePrefix");
		ignoreColumnPrefix = properties.getProperty("ignoreColumnPrefix");
		ignoreWordSeparator = properties.getProperty("ignoreWordSeparator");
		
		String camelCase = properties.getProperty("useCamelCase");
		useCamelCase = camelCase != null && camelCase.equalsIgnoreCase("true") ? true : false;
		
		tableInfo = properties.getProperty("exportTableInfo").split(",");
		columnInfo = properties.getProperty("exportColumnInfo").split(",");

		Analizer.setProperties(properties);
		
	}
	
	protected int export(Connection connection, List<TableDef> tableDefList) {
		
		System.out.format("Building tables definitions to path %s.%n", exportPath);
		
		int count = 0;
		
		// Empty path
//		File path = new File(exportPath);

//		System.out.format("Deleting old files below path %s.%n", exportPath);

//		try {
//			FileUtils.deleteDirectory(path);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		// Generate xml for tables
		for (TableDef tableDef : tableDefList) {

			System.out.format("Building table %s.%s.%s.%n", tableDef.getCatalog() == null ? "" : tableDef.getCatalog(), tableDef.getSchema(), tableDef.getName());

			// List columns of table
			List<ColumnDef> columnDefList = DatabaseHelper.listColumns(connection, tableDef, columnInfo);
			
			tableDef.getColumnDefs().addAll(columnDefList);

			// Apply name conventions for table
			tableDef.setClassName(getClassName(tableDef.getName(), true));

			// Apply name conventions for columns
			for (ColumnDef columnDef : columnDefList) {
				columnDef.setPropertyName(getPropertyName(columnDef.getColumnName(), false));
				columnDef.setShortColumnName(getShortColumnName(columnDef.getColumnName()));
				columnDef.setIdentity(isIdentity(columnDef.getTypeName()));
				columnDef.setPropertyType(getPlatformTypeName(columnDef.getTypeName(), columnDef.getColumnSize(), columnDef.getDecimalDigits()));
				columnDef.setFieldType(getPlatformFieldTypeName(columnDef.getPropertyType()));
			}
			
			// Fill pk info for table
			DatabaseHelper.fillPk(connection, tableDef);
			
			// Create path if not exists
			String fileName = exportPath
					+ (tableDef.getCatalog() == null ? "" : tableDef.getCatalog() + "_")
					+ tableDef.getSchema() + "_" 
					+ tableDef.getName() + ".xml";
			
			File file = new File(fileName);
			
			file.getParentFile().mkdirs();
			
			System.out.format("Deleting old file %s.%n", fileName);
			file.delete();
			
			// Export file to intended format
			this.saveObject(tableDef, file, fileName);
			
			count++;
			
		}
		
		return count;
		
	}
	
	protected int build(List<String> templates, List<String> definitions) {
		
		System.out.format("Building target files to path %s.%n", buildPath);
		
		int count = 0;
		
		System.out.format("Compile templates to build files.%n");
		
		if (templates.size() == 0) {
    		System.err.format("There is no template to build the files.%n");
		}
		
		for (String templateName : templates) {
			
			String fileName = templatePath + templateName;
			
			File file = new File(fileName);
			
			if (file.exists() && file.isFile()) {
				
				StringBuffer template = getFile(file);
				
				if (template.length() == 0) {
					System.out.format("Template %s is empty.%n", fileName);
				} else {
					
					// Validate templates
					if (Analizer.analize(template)) {
						
						System.out.format("Template was successfully analized.%n");
						
						for (String definition : definitions) {
							
							String tableDefFileName = exportPath + definition;
							
							// Parse xml to object
							TableDef tableDef = parseObject(tableDefFileName);
							
							if (tableDef != null) {
								
								for (ColumnDef columnDef : tableDef.getColumnDefs()) {
									columnDef.setTableDef(tableDef);
								}
								
								String module = Analizer.getFileModule() + (Analizer.getFileModule().equals("") ? "" : PATH_SEPARATOR);
								
								String filePath = Analizer.getFilePath() != null ? Analizer.getFilePath() + PATH_SEPARATOR : "";
								
								String targetFileName = buildPath + module + filePath +  Analizer.getFilePrefix() + tableDef.getClassName() + Analizer.getFileSufix();
								
								System.out.format("Deleting possible old file %s.%n", targetFileName);
								
								// Delete old file
								File path = new File(targetFileName);
								path.getParentFile().mkdirs();
								path.delete();
								
								// Compile
								StringBuffer result = Analizer.build(template, tableDef);
								
								System.out.format("%s%n", result.toString());
								
								// Save the file
								saveFile(path, result);
								
								count++;
								
							} else {
								System.err.format("Cannot build file %s.%n", definition);
							}
							
						}
						
					}
					
				}
				
			} else {
	    		System.err.format("Template file not found: Cannot find the file %s to compile.%n", fileName);
			}
			
		}
		
		return count;
		
	}
	
	private String getClassName (String tableName, boolean camel) {
		
		String name = "";
		
		if (ignoreTablePrefix != null) {
			int i=0;
			for (; i < ignoreTablePrefix.length(); i++) {
				if (ignoreTablePrefix.charAt(i) != '?') {
					if (ignoreTablePrefix.charAt(i) != tableName.charAt(i)) break;
				}
			}
			if (i == ignoreTablePrefix.length()) {
				name = tableName.substring(i, tableName.length());
			} else {
				name = tableName;
			}
		} else {
			name = tableName;
		}
		
		if (!name.equals(tableName)) {
			name = getClassName(name, camel);
		} else {
			if (useCamelCase) {
				name = capitalize(name, camel);
			}
			
			if (ignoreWordSeparator != null) {
				name = name.replaceAll(ignoreWordSeparator, "");
			}
		}
		
		return name;
		
	}
	
	private String getPropertyName (String columnName, boolean camel) {
		
		String name = "";
		
		if (ignoreColumnPrefix != null) {
			int i=0;
			for (; i < ignoreColumnPrefix.length(); i++) {
				if (ignoreColumnPrefix.charAt(i) != '?') {
					if (ignoreColumnPrefix.charAt(i) != columnName.charAt(i)) break;
				}
			}
			if (i == ignoreColumnPrefix.length()) {
				name = columnName.substring(i, columnName.length());
			} else {
				name = columnName;
			}
		} else {
			name = columnName;
		}

		if (!name.equals(columnName)) {
			name = getPropertyName(name, camel);
		} else {
			if (useCamelCase) {
				name = capitalize(name, camel);
			}
			
			if (ignoreWordSeparator != null) {
				name = name.replaceAll(ignoreWordSeparator, "");
			}
		}
		
		return name;
		
	}
	
	private String getShortColumnName (String columnName) {
		
		String name = "";
		
		if (ignoreColumnPrefix != null) {
			int i=0;
			for (; i < ignoreColumnPrefix.length(); i++) {
				if (ignoreColumnPrefix.charAt(i) != '?') {
					if (ignoreColumnPrefix.charAt(i) != columnName.charAt(i)) break;
				}
			}
			if (i == ignoreColumnPrefix.length()) {
				name = columnName.substring(i, columnName.length());
			} else {
				name = columnName;
			}

		} else {
			name = columnName;
		}
		
		if (!name.equals(columnName)) {
			name = getShortColumnName(name);
		} else {
			name = name.toUpperCase();
		}
		
		return name;
		
	}
	
	private String capitalize (String text, boolean camel) {
		
		StringBuffer result = new StringBuffer(text.length());
		String strl = text;
		boolean capitalize = camel;
		
		for (int i = 0; i < strl.length(); i++) {
			char c = strl.charAt(i);
			if (c >= 'a' && c <= 'z') {
				if (capitalize) {
					result.append(Character.toUpperCase(c));
					capitalize = false;
				} else {
					result.append(c);
				}
			} else if (c >= 'A' && c <= 'Z') {
				if (capitalize) {
					result.append(c);
					capitalize = false;
				} else {
					result.append(Character.toLowerCase(c));
				}
			} else {
				result.append(c);
				capitalize = true;
			}
		}
		
		return result.toString();
		
	}
	
	private String getPlatformTypeName (String sqlTypeName, Integer length, Integer decimal) {
		String [][] types = null;
		
		types = new String[][] { 
				{"CHAR", "String"} // Types.CHAR
				, {"VARCHAR", "String"} // Types.VARCHAR
				, {"LONGVARCHAR", "String"} // Types.LONGVARCHAR
				, {"NUMERIC", "java.math.BigDecimal"} // Types.NUMERIC
				, {"DECIMAL", "java.math.BigDecimal"} // Types.DECIMAL
				, {"BIT", "Boolean"} // Types.BIT
				, {"BOOLEAN", "Boolean"} // Types.BOOLEAN
				, {"TINYINT", "byte"} // Types.TINYINT
				, {"SMALLINT", "Short"} // Types.SMALLINT
				, {"INTEGER", "Integer"} // Types.INTEGER
				, {"BIGINT", "Long"} // Types.BIGINT
				, {"REAL", "Float"} // Types.REAL
				, {"FLOAT", "Double"} // Types.FLOAT
				, {"DOUBLE", "Double"} // Types.DOUBLE
				, {"BINARY", "byte[]"}  // Types.BINARY
				, {"VARBINARY", "byte[]"} // Types.VARBINARY
				, {"LONGVARBINARY", "byte[]"} // Types.LONGVARBINARY
				, {"DATE", "java.util.Date"} // Types.DATE
				, {"TIME", "java.sql.Time"} // Types.TIME
				, {"TIMESTAMP", "java.sql.Timestamp"} // Types.TIMESTAMP
				, {"CLOB", "Clob"} // Types.CLOB
				, {"BLOB", "Blob"} // Types.BLOB
				, {"ARRAY", "Array"} // Types.ARRAY
				, {"DISTINCT", ""} // Types.DISTINCT
				, {"STRUCT", "Struct"} // Types.STRUCT
				, {"REF", "Ref"} // Types.REF
				, {"DATALINK", "java.net.URL"} // Types.DATALINK
				, {"JAVA_OBJECT", ""} // Types.JAVA_OBJECT
				, {"text", "String"} // Types.LONGVARCHAR
				, {"datetime", "java.util.Date"} // Types.TIME
				, {"numeric() identity", "Integer"} //
				// PostgreSQL
				, {"serial", "Integer"} //
				, {"bool", "Boolean"} // Types.BOOLEAN
				, {"int4", "Integer"} //
				, {"int2", "Short"} //
				, {"float4", "Float"} //
				, {"float8", "Double"} //
				, {"bpchar", "String"} //
		};
		
		for (String[] type : types) {
			if (type[0].equalsIgnoreCase(sqlTypeName)) {
				if (type[0].equals("NUMERIC")) {
					if (decimal > 0) {
						return type[1];
					} else if (length < 3) {
						return "Byte";
					} else if (length < 5) {
						return "Short";
					} else if (length < 10) {
						return "Integer";
					} else {
						return "Long";
					}
				} else {
					return type[1];
				}
			}
		}
		
		return "";
	}
	
	private boolean isIdentity (String typeName) {
		return typeName.indexOf("identity") > -1 || typeName.indexOf("serial") > -1;
	}
	
	private String getPlatformFieldTypeName (String typeName) {
		String [][] types = new String[][] { 
				{"String", "String"}
				, {"java.math.BigDecimal", "BigDecimal"}
				, {"Boolean", "Boolean"}
				, {"byte", "Byte"}
				, {"Short", "Short"}
				, {"Integer", "Int"}
				, {"Long", "Long"}
				, {"Float", "Float"}
				, {"Double", "Double"}
				, {"byte[]", "Byte[]"}
				, {"java.util.Date", "Date"}
				, {"java.sql.Time", "Time"}
				, {"java.sql.Timestamp", "Timestamp"}
				, {"Clob", "Clob"}
				, {"Blob", "Blob"}
				, {"Array", "Array"}
				, {"Struct", "Struct"}
				, {"Ref", "Ref"}
				, {"java.net.URL", "java.net.URL"}
		};
		
		for (String[] type : types) {
			if (type[0].equalsIgnoreCase(typeName)) {
				return type[1];
			}
		}
		
		return "";
	}
	
	private StringBuffer getFile (File file) {
		
		System.out.format("Loading file %s.%n", file.getName());

		FileReader reader = null;
		BufferedReader buffer = null;
		
		try {
			
			reader = new FileReader(file);
			buffer = new BufferedReader(reader);
			
			StringBuffer template = new StringBuffer((int)file.length());
			
			String line;
			while ((line = buffer.readLine()) != null) {
				template.append(line).append("\n");
			}
			
			return template;
			
		} catch (FileNotFoundException e) {
    		System.err.format("File not found: Cannot find the file %s to load.%n", file.getName());
		} catch (IOException e) {
			System.err.format("Error while loading file %s.%n", file.getName());
		} finally {
			if (buffer != null) {
				try {
					buffer.close();
				} catch (IOException e) {
				}
			}
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
				}
			}
		}
		
		return new StringBuffer("");
		
	}
	
	private void saveFile (File file, StringBuffer content) {
		
		System.out.format("Saving file %s.%n", file.getName());

		FileWriter writer = null;
		BufferedWriter buffer = null;
		
		try {
			
			writer = new FileWriter(file);
			buffer = new BufferedWriter(writer);

			buffer.write(content.toString());
			buffer.flush();
			
		} catch (IOException e) {
			System.err.format("Error while saving file %s.%n", file.getName());
			e.printStackTrace();
		} finally {
			if (buffer != null) {
				try {
					buffer.close();
				} catch (IOException e) {
				}
			}
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
				}
			}
		}
		
	}
	
	public Properties getProperties() {
		return properties;
	}
	
	public void setProperties(Properties properties) {
	}
	
}
