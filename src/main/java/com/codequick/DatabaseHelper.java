package com.codequick;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.codequick.model.ColumnDef;
import com.codequick.model.TableDef;

public class DatabaseHelper {
	
	// http://docs.oracle.com/javase/6/docs/api/java/sql/DatabaseMetaData.html#getTableTypes()
	// getImportedKeys
	
	public static List<TableDef> listTables (Connection connection, String schemas, String[] columns) {
		
		if (connection == null) {
			System.err.format("Database connection error: Cannot connect with database.%n");
			System.exit(1);
		}
		
		System.out.format("Listing tables from schemas %s.%n", schemas);
		
		String[] schemaList = schemas.split(",");
		
		List<TableDef> tableDefList = new ArrayList<TableDef>(0);
    	DatabaseMetaData md;
    	
    	for (String schema : schemaList) {
    		
    		try {
    			md = connection.getMetaData();
    			ResultSet rs = md.getTables(null, schema, "%", new String [] {"TABLE"});
    			while (rs.next()) {
    				TableDef tableDef = new TableDef();
    				for (String column : columns) {
    					if (column.equals("TABLE_CAT")) tableDef.setCatalog(getString(rs, "TABLE_CAT"));
    					if (column.equals("TABLE_SCHEM")) tableDef.setSchema(getString(rs, "TABLE_SCHEM"));
    					if (column.equals("TABLE_NAME")) tableDef.setName(getString(rs, "TABLE_NAME"));
    					if (column.equals("TABLE_TYPE")) tableDef.setType(getString(rs, "TABLE_TYPE"));
    					if (column.equals("REMARKS")) tableDef.setRemarks(getString(rs, "REMARKS"));
    					if (column.equals("TYPE_CAT")) tableDef.setTypeCatalog(getString(rs, "TYPE_CAT"));
    					if (column.equals("TYPE_SCHEM")) tableDef.setTypeSchema(getString(rs, "TYPE_SCHEM"));
    					if (column.equals("TYPE_NAME")) tableDef.setTypeName(getString(rs, "TYPE_NAME"));
    					if (column.equals("SELF_REFERENCING_COL_NAME")) tableDef.setSelfReferencingColName(getString(rs, "SELF_REFERENCING_COL_NAME"));
    					if (column.equals("REF_GENERATION")) tableDef.setRefGeneration(getString(rs, "REF_GENERATION"));
    				}
    				tableDefList.add(tableDef);
    				
    				System.out.format("+-------------------------------------------------------+%n");
    				System.out.format("TABLE_CAT................: %s%n", tableDef.getCatalog());
    				System.out.format("TABLE_SCHEM..............: %s%n", tableDef.getSchema());
    				System.out.format("TABLE_NAME...............: %s%n", tableDef.getName());
    				System.out.format("TABLE_TYPE...............: %s%n", tableDef.getType());
    				System.out.format("REMARKS..................: %s%n", tableDef.getRemarks());
    				System.out.format("TYPE_CAT.................: %s%n", tableDef.getTypeCatalog());
    				System.out.format("TYPE_SCHEM...............: %s%n", tableDef.getTypeSchema());
    				System.out.format("TYPE_NAME................: %s%n", tableDef.getTypeName());
    				System.out.format("SELF_REFERENCING_COL_NAME: %s%n", tableDef.getSelfReferencingColName());
    				System.out.format("REF_GENERATION...........: %s%n", tableDef.getRefGeneration());
    				System.out.format("+-------------------------------------------------------+%n%n");
    			}
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    		
    	}

		return tableDefList;
	}
	
	public static List<ColumnDef> listColumns (Connection connection, TableDef tableDef, String[] columns) {
		System.out.format("Listing columns from table %s.%s.%s.%n", tableDef.getCatalog(), tableDef.getSchema(), tableDef.getName());
		
		List<ColumnDef> columnDefList = new ArrayList<ColumnDef>(0);
    	DatabaseMetaData md;
    	
		try {
			md = connection.getMetaData();
			ResultSet rs = md.getColumns(tableDef.getCatalog(), tableDef.getSchema(), tableDef.getName(), "%");
			while (rs.next()) {
				ColumnDef columnDef = new ColumnDef();
				for (String column : columns) {
					if (column.equals("TABLE_CAT")) columnDef.setCatalog(getString(rs, "TABLE_CAT"));
					if (column.equals("TABLE_SCHEM")) columnDef.setSchema(getString(rs, "TABLE_SCHEM"));
					if (column.equals("TABLE_NAME")) columnDef.setTableName(getString(rs, "TABLE_NAME"));
					if (column.equals("COLUMN_NAME")) columnDef.setColumnName(getString(rs, "COLUMN_NAME"));
					if (column.equals("DATA_TYPE")) columnDef.setDataType(getInt(rs, "DATA_TYPE"));
					if (column.equals("TYPE_NAME")) columnDef.setTypeName(getString(rs, "TYPE_NAME"));
					if (column.equals("COLUMN_SIZE")) columnDef.setColumnSize(getInt(rs, "COLUMN_SIZE"));
					if (column.equals("DECIMAL_DIGITS")) columnDef.setDecimalDigits(getInt(rs, "DECIMAL_DIGITS"));
					if (column.equals("NUM_PREC_RADIX")) columnDef.setRadix(getInt(rs, "NUM_PREC_RADIX"));
					if (column.equals("NULLABLE")) columnDef.setNullable(getInt(rs, "NULLABLE"));
					if (column.equals("REMARKS")) columnDef.setRemarks(getString(rs, "REMARKS"));
					if (column.equals("COLUMN_DEF")) columnDef.setColumnDefault(getString(rs, "COLUMN_DEF"));
					if (column.equals("CHAR_OCTET_LENGTH")) columnDef.setCharOctetLength(getInt(rs, "CHAR_OCTET_LENGTH"));
					if (column.equals("ORDINAL_POSITION")) columnDef.setOrdinalPosition(getInt(rs, "ORDINAL_POSITION"));
					if (column.equals("IS_NULLABLE")) columnDef.setIsNullable(getString(rs, "IS_NULLABLE"));
					if (column.equals("SCOPE_CATLOG")) columnDef.setScopeCatalog(getString(rs, "SCOPE_CATLOG"));
					if (column.equals("SCOPE_SCHEMA")) columnDef.setScopeSchema(getString(rs, "SCOPE_SCHEMA"));
					if (column.equals("SCOPE_TABLE")) columnDef.setScopeTable(getString(rs, "SCOPE_TABLE"));
					if (column.equals("SOURCE_DATA_TYPE")) columnDef.setSourceDataType(getShort(rs, "SOURCE_DATA_TYPE"));
					if (column.equals("IS_AUTOINCREMENT")) columnDef.setIsAutoincrement(getString(rs, "IS_AUTOINCREMENT"));
				}
				columnDefList.add(columnDef);
				
				System.out.format("+-------------------------------------------------------+%n");
				System.out.format("TABLE_CAT........: %s%n", columnDef.getCatalog());
				System.out.format("TABLE_SCHEM......: %s%n", columnDef.getSchema());
				System.out.format("TABLE_NAME.......: %s%n", columnDef.getTableName());
				System.out.format("COLUMN_NAME......: %s%n", columnDef.getColumnName());
				System.out.format("DATA_TYPE........: %s%n", columnDef.getDataType());
				System.out.format("TYPE_NAME........: %s%n", columnDef.getTypeName());
				System.out.format("COLUMN_SIZE......: %s%n", columnDef.getColumnSize());
				System.out.format("DECIMAL_DIGITS...: %s%n", columnDef.getDecimalDigits());
				System.out.format("NUM_PREC_RADIX...: %s%n", columnDef.getRadix());
				System.out.format("NULLABLE.........: %s%n", columnDef.getNullable());
				System.out.format("REMARKS..........: %s%n", columnDef.getRemarks());
				System.out.format("COLUMN_DEF.......: %s%n", columnDef.getColumnDefault());
				System.out.format("CHAR_OCTET_LENGTH: %s%n", columnDef.getCharOctetLength());
				System.out.format("ORDINAL_POSITION.: %s%n", columnDef.getOrdinalPosition());
				System.out.format("IS_NULLABLE......: %s%n", columnDef.getIsNullable());
				System.out.format("SCOPE_CATLOG.....: %s%n", columnDef.getScopeCatalog());
				System.out.format("SCOPE_SCHEMA.....: %s%n", columnDef.getScopeSchema());
				System.out.format("SCOPE_TABLE......: %s%n", columnDef.getScopeTable());
				System.out.format("SOURCE_DATA_TYPE.: %s%n", columnDef.getSourceDataType());
				System.out.format("IS_AUTOINCREMENT.: %s%n", columnDef.getIsAutoincrement());
				System.out.format("+-------------------------------------------------------+%n%n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return columnDefList;
	}

	public static void fillPk (Connection connection, TableDef tableDef) {
		
		if (connection == null) {
			System.err.format("Database connection error: Cannot connect with database.%n");
			System.exit(1);
		}
		
		System.out.format("Listing primary keys from table %s.%s.%s.%n", tableDef.getCatalog(), tableDef.getSchema(), tableDef.getName());
		
    	DatabaseMetaData md;
    	
    	try {
    		md = connection.getMetaData();
    		ResultSet rs = md.getPrimaryKeys(tableDef.getCatalog(), tableDef.getSchema(), tableDef.getName());
    		while (rs.next()) {
    			String columnName = getString(rs, "COLUMN_NAME");
    			tableDef.setPkName(getString(rs, "PK_NAME"));
    			for (ColumnDef columnDef : tableDef.getColumnDefs()) {
    				if (columnDef.getColumnName().equals(columnName)) {
    					columnDef.setKeySeq(getShort(rs, "KEY_SEQ"));
    					System.out.format("+-------------------------------------------------------+%n");
    					System.out.format("TABLE_CAT................: %s%n", tableDef.getCatalog());
    					System.out.format("TABLE_SCHEM..............: %s%n", tableDef.getSchema());
    					System.out.format("TABLE_NAME...............: %s%n", tableDef.getName());
    					System.out.format("COLUMN_NAME..............: %s%n", columnName);
    					System.out.format("KEY_SEQ..................: %s%n", columnDef.getKeySeq());
    					System.out.format("PK_NAME..................: %s%n", tableDef.getPkName());
    					System.out.format("+-------------------------------------------------------+%n%n");
    					break;
    				}
    			}
    			
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
	}
	
	private static String getString (ResultSet rs, String column) {
		try {
			if (rs.getObject(column) != null) {
				return rs.getString(column);
			}
		} catch (SQLException e) {
		}
		return null;
	}
	
	private static int getInt (ResultSet rs, String column) {
		try {
			if (rs.getObject(column) != null) {
				return rs.getInt(column);
			}
		} catch (SQLException e) {
		}
		return 0;
	}
	
	private static short getShort (ResultSet rs, String column) {
		try {
			if (rs.getObject(column) != null) {
				return rs.getShort(column);
			}
		} catch (SQLException e) {
		}
		return 0;
	}
	
}
