package com.codequick;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.codequick.model.TableDef;
import com.codequick.util.DBConnectionFactory;

/**
 * 
 */
public class Codequick {
	
	private static final String WORKING_DIRECTORY = System.getProperty("user.dir");
	
	private static boolean isExport;
	private static boolean isBuild;
	
	public static String CONFIG_PATH = WORKING_DIRECTORY + "/config/";
	private static String CONFIG_FILE = "config.properties";
	private static final Package PKG = Codequick.class.getPackage();
	
    public static void main (String[] args) throws Exception {
    	
    	System.out.format("Starting %s - Version %s.%n"
    			, PKG.getSpecificationTitle()
    			, PKG.getSpecificationVersion());
    	
    	initialize(args);
    	
    }
    
    private static void initialize (String[] args) throws Exception {
    	
    	System.out.format("Initializing %s.%n", PKG.getSpecificationTitle());
    	
    	checkParameter(args);

		Properties properties = loadProperties (CONFIG_PATH + CONFIG_FILE);

    	Engine engine = Engine.getInstance(properties);

    	if (isExport) exportDefinition (engine);
    	
    	if (isBuild) buildFiles (engine);
    	
    }
    
    private static void checkParameter (String[] args) {
    	
    	System.out.format("Checking for parameters.%n");
    	
    	if (args == null || (args.length < 1 && args.length > 2)) {
    		System.err.format("Argument error: Number of parameters is invalid.%n");
    		System.exit(1);
    	}
    	
    	for (String arg : args) {
    		System.out.format("Checking argument [%s].%n", arg);
    		
    		if (arg.equalsIgnoreCase("-export")) isExport = true;
    		if (arg.equalsIgnoreCase("-build")) isBuild = true;
    		if (arg.startsWith("-config")) {
    			int start = arg.indexOf("=");
    			int lastBar = arg.lastIndexOf("/");
    			CONFIG_PATH = arg.substring(start+1, lastBar+1);
    			CONFIG_FILE = arg.substring(lastBar+1, arg.length());
    		}
    	}
    	
    	if ((!isExport && !isBuild) || (isExport && isBuild)) {
    		System.err.format("Argument error: Type only one of [-export|-build].%n");
    		System.exit(1);
    	}
    	
    	System.out.format("Parameters is ok.%n");

    }
    
    private static void exportDefinition (Engine engine) throws Exception { 
    	
    	String path = engine.getProperties().getProperty("driverPath");
    	String driver = engine.getProperties().getProperty("driverName");
    	String url = engine.getProperties().getProperty("connectionUrl");
    	String user = engine.getProperties().getProperty("userName");
    	String password = engine.getProperties().getProperty("password");
    	String schemas = engine.getProperties().getProperty("schemas");
    	
    	// Getting external connection (from config.properties)
    	Connection connection = DBConnectionFactory.getConnection(path, driver, url, user, password);
    	
    	// Getting table list from external (from config.properties)
    	List<TableDef> tableDefList = DatabaseHelper.listTables(connection, schemas, engine.getProperties().getProperty("exportTableInfo").split(","));
    	
    	int count = engine.export(connection, filterTables(engine, tableDefList));
    	
    	System.out.format("%s tables has been exported.%n", count);
    	
    	DBConnectionFactory.closeConnection(connection);
    	
    }
 
    private static void buildFiles (Engine engine) {
    	
    	File path = new File(engine.templatePath);
    	File[] files = path.listFiles(new FilenameFilter() {
    	    public boolean accept(File dir, String name) {
    	        return name.toLowerCase().endsWith(".cq");
    	    }
    	});
    	
    	// Getting external list of templates (from config.properties)
    	List<String> templates = new ArrayList<String>();
    	for (File file : files) {
    		templates.add(file.getName());
    	}
    	
    	path = new File(engine.exportPath);
    	files = path.listFiles(new FilenameFilter() {
    	    public boolean accept(File dir, String name) {
    	        return name.toLowerCase().endsWith(".xml");
    	    }
    	});
    	
    	// Getting external list of definitions (from config.properties)
    	List<String> definitions = new ArrayList<String>();
    	for (File file : files) {
    		definitions.add(file.getName());
    	}
    	
    	int count = engine.build(filterTemplates(engine, templates), filterDefinitions(engine, definitions));
    	
    	System.out.format("%s files has been built.%n", count);
    	
    }
    
    private static List<String> filterTemplates (Engine engine, List<String> templates) {
    	
    	String templateList = engine.getProperties().getProperty("templateList");
    	
    	if (templateList != null && !templateList.equals("")) {
    		String[] userTemplates = templateList.split(",");
    		
    		List<String> matchTemplates = new ArrayList<String> (0);
    		
    		for (String template : templates) {
    			for (String userTemplate : userTemplates) {
    				if (template.equalsIgnoreCase(userTemplate.trim())) {
    					matchTemplates.add(template);
    				}
    			}
    		}

    		return matchTemplates;
    	}
    	
    	return templates;

    }
    
    private static List<String> filterDefinitions (Engine engine, List<String> definitions) {
    	
    	String definitionList = engine.getProperties().getProperty("definitionList");
    	
    	if (definitionList != null && !definitionList.equals("")) {
    		String[] userDefinitions = definitionList.split(",");
    		
    		List<String> matchDefinitions = new ArrayList<String> (0);
    		
    		for (String definition : definitions) {
    			for (String userDefinition : userDefinitions) {
    				if (definition.equalsIgnoreCase(userDefinition.trim())) {
    					matchDefinitions.add(definition);
    				}
    			}
    		}

    		return matchDefinitions;
    	}
    	
    	return definitions;

    }
    
    private static List<TableDef> filterTables (Engine engine, List<TableDef> tableDefList) {
    	
    	String tableList = engine.getProperties().getProperty("tableList");
    	
    	if (tableList != null && !tableList.equals("")) {
    		String[] tables = tableList.split(",");
    		
    		List<TableDef> matchTables = new ArrayList<TableDef> (0);
    		
    		for (TableDef tableDef : tableDefList) {
    			for (String table : tables) {
    				if (tableDef.getName().equalsIgnoreCase(table.trim())) {
    					matchTables.add(tableDef);
    				}
    			}
    		}

    		return matchTables;
    	}
    	
    	return tableDefList;

    }
    
	public static Properties loadProperties (String propertyFile) {
		
		System.out.format("Loading properties %s.%n", propertyFile);
		
		Properties properties = new Properties();
		 
    	try {
 
    		// Load a properties file
    		properties.load(new FileInputStream(propertyFile));
    		
    	} catch (IOException ex) {
    		ex.printStackTrace();
        }

    	return properties;
	}
	
}