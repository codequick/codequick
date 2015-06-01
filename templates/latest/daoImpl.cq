@@[template:DAOImpl Template]@@
@@[project:Codequick Sample]@@
@@[version:1.0]@@
@@[author:Marcelo Torres]@@
@@[licence:GNU GPL 3]@@

@@[fileType:Java]@@
@@[fileModule:ejb]@@
@@[filePath:@@[getVar:daoImplPackageName]@@]@@
@@[filePrefix:]@@
@@[fileSufix:DaoImpl.java]@@

@@[content:
package @@[getVar:daoImplPackageName]@@;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.codequick.common.data.DAOBaseImpl;
import com.codequick.common.data.PrepareStatementCallbackHandler;
import @@[getVar:daoPackageName]@@.CountryDAO;
import @@[getVar:mapperPackageName]@@.@@[get:tableDef.className]@@Mapper;
import @@[getVar:modelPackageName]@@.@@[get:tableDef.className]@@;

public class @@[get:tableDef.className]@@DAOImpl extends DAOBaseImpl implements @@[get:tableDef.className]@@DAO {

	public int insert(final @@[get:tableDef.className]@@ @@[lowerFirst:@@[get:tableDef.className]@@]@@) {
		
		StringBuffer sql = new StringBuffer();
		sql.append("\n insert into ").append(@@[get:tableDef.className]@@.TABLE).append(" (");
	@@[loop:tableDef.columnDefs@@;
		@@[if:@@[item:first]@@@@;sql.append("\n ").append(@@[get:columnDef.tableDef.className]@@.@@[get:columnDef.shortColumnName]@@);@@;sql.append("\n , ").append(@@[get:columnDef.tableDef.className]@@.@@[get:columnDef.shortColumnName]@@);]@@
	filter:@@[not:@@[get:columnDef.identity]@@]@@]@@
		sql.append("\n ) values (@@[loop:tableDef.columnDefs@@;@@[if:@@[item:first]@@@@;?@@;, ?]@@filter:@@[not:@@[get:columnDef.identity]@@]@@]@@) ");
		
		final int result = this.execute(sql.toString()
				, new PrepareStatementCallbackHandler() {
			
			public void execute(PreparedStatement statement) throws SQLException {
				int i = 1;
	@@[loop:tableDef.columnDefs@@;
				statement.set@@[get:columnDef.fieldType]@@(i++, @@[lowerFirst:@@[get:columnDef.tableDef.className]@@]@@.get@@[upperFirst:@@[get:columnDef.propertyName]@@]@@());
	filter:@@[not:@@[get:columnDef.identity]@@]@@]@@
			}
			
		});

		return result;
		
	}
	
	public @@[get:tableDef.className]@@ findByID(final @@[get:tableDef.className]@@ @@[lowerFirst:@@[get:tableDef.className]@@]@@) {
		
		StringBuffer sql = new StringBuffer();
		sql.append("\n select * from ").append(@@[get:tableDef.className]@@.TABLE);
	@@[loop:tableDef.columnDefs@@;
		@@[if:@@[item:first]@@@@;sql.append("\n where ").append(@@[get:columnDef.tableDef.className]@@.@@[get:columnDef.shortColumnName]@@)@@;sql.append("\n   and ").append(@@[get:columnDef.tableDef.className]@@.@@[get:columnDef.shortColumnName]@@)]@@.append(" = ? ");
	filter:@@[isNotNull:columnDef.keySeq]@@]@@
		
		return this.executeQueryObject(sql.toString()
				, new PrepareStatementCallbackHandler() {
			
			public void execute(PreparedStatement statement) throws SQLException {
				int i = 1;
	@@[loop:tableDef.columnDefs@@;
				statement.set@@[get:columnDef.fieldType]@@(i++, @@[lowerFirst:@@[get:columnDef.tableDef.className]@@]@@.get@@[upperFirst:@@[get:columnDef.propertyName]@@]@@());
	filter:@@[isNotNull:columnDef.keySeq]@@]@@
			}
			
		}, new @@[get:tableDef.className]@@Mapper());
		
	}
	
	public List<@@[get:tableDef.className]@@> listAll() {
		
		StringBuffer sql = new StringBuffer();
		sql.append("\n select * from ").append(@@[get:tableDef.className]@@.TABLE);
		
		final List<@@[get:tableDef.className]@@> result = this.executeQuery(sql.toString()
				, new PrepareStatementCallbackHandler() {
			
			public void execute(PreparedStatement statement) throws SQLException {
			}
			
		}, new @@[get:tableDef.className]@@Mapper());
		
		return result;
		
	}
	
	public int update(final @@[get:tableDef.className]@@ @@[lowerFirst:@@[get:tableDef.className]@@]@@) {
		
		StringBuffer sql = new StringBuffer();
		sql.append("\n update ").append(@@[get:tableDef.className]@@.TABLE);
	@@[loop:tableDef.columnDefs@@;
		@@[if:@@[item:first]@@@@;sql.append("\n set ").append(@@[get:columnDef.tableDef.className]@@.@@[get:columnDef.shortColumnName]@@)@@;sql.append("\n   , ").append(@@[get:columnDef.tableDef.className]@@.@@[get:columnDef.shortColumnName]@@)]@@.append(" = ? ");
	filter:@@[isNull:columnDef.keySeq]@@]@@
	@@[loop:tableDef.columnDefs@@;
		@@[if:@@[item:first]@@@@;sql.append("\n where ").append(@@[get:columnDef.tableDef.className]@@.@@[get:columnDef.shortColumnName]@@)@@;sql.append("\n   and ").append(@@[get:columnDef.tableDef.className]@@.@@[get:columnDef.shortColumnName]@@)]@@.append(" = ? ");
	filter:@@[isNotNull:columnDef.keySeq]@@]@@

		final int result = this.execute(sql.toString()
				, new PrepareStatementCallbackHandler() {
			
			public void execute(PreparedStatement statement) throws SQLException {
				int i = 1;
	@@[loop:tableDef.columnDefs@@;
				statement.set@@[get:columnDef.fieldType]@@(i++, @@[lowerFirst:@@[get:columnDef.tableDef.className]@@]@@.get@@[upperFirst:@@[get:columnDef.propertyName]@@]@@());
	filter:@@[isNull:columnDef.keySeq]@@]@@
	@@[loop:tableDef.columnDefs@@;
				statement.set@@[get:columnDef.fieldType]@@(i++, @@[lowerFirst:@@[get:columnDef.tableDef.className]@@]@@.get@@[upperFirst:@@[get:columnDef.propertyName]@@]@@());
	filter:@@[isNotNull:columnDef.keySeq]@@]@@
			}
			
		});

		return result;
		
	}
	
	public int delete(final @@[get:tableDef.className]@@ @@[lowerFirst:@@[get:tableDef.className]@@]@@) {
		
		StringBuffer sql = new StringBuffer();
		sql.append("\n delete from ").append(@@[get:tableDef.className]@@.TABLE);
	@@[loop:tableDef.columnDefs@@;
		@@[if:@@[item:first]@@@@;sql.append("\n where ").append(@@[get:columnDef.tableDef.className]@@.@@[get:columnDef.shortColumnName]@@)@@;sql.append("\n   and ").append(@@[get:columnDef.tableDef.className]@@.@@[get:columnDef.shortColumnName]@@)]@@.append(" = ? ");
	filter:@@[isNotNull:columnDef.keySeq]@@]@@
		
		final int result = this.execute(sql.toString()
				, new PrepareStatementCallbackHandler() {
			
			public void execute(PreparedStatement statement) throws SQLException {
				int i = 1;
	@@[loop:tableDef.columnDefs@@;
				statement.set@@[get:columnDef.fieldType]@@(i++, @@[lowerFirst:@@[get:columnDef.tableDef.className]@@]@@.get@@[upperFirst:@@[get:columnDef.propertyName]@@]@@());
	filter:@@[isNotNull:columnDef.keySeq]@@]@@
			}
			
		});
		
		return result;
		
	}

}
]@@
