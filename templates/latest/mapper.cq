@@[template:Mapper Template]@@
@@[project:Codequick Sample]@@
@@[version:1.0]@@
@@[author:Marcelo Torres]@@
@@[licence:GNU GPL 3]@@

@@[fileType:Java]@@
@@[fileModule:ejb]@@
@@[filePath:@@[getVar:mapperPackageName]@@]@@
@@[filePrefix:]@@
@@[fileSufix:Mapper.java]@@

@@[content:
package @@[getVar:daoPackageName]@@;

import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.codequick.common.data.MapperCallbackHandler;
import @@[getVar:modelPackageName]@@.@@[get:tableDef.className]@@;

public class @@[get:tableDef.className]@@Mapper implements MapperCallbackHandler<@@[get:tableDef.className]@@> {

	public @@[get:tableDef.className]@@ execute(ResultSet rs) throws SQLException {
		@@[get:tableDef.className]@@ @@[lowerFirst:@@[get:tableDef.className]@@]@@ = new @@[get:tableDef.className]@@();
		
	@@[loop:tableDef.columnDefs@@;
		@@[lowerFirst:@@[get:columnDefs.tableDef.className]@@]@@.set@@[upperFirst:@@[get:columnDef.propertyName]@@]@@(rs.get@@[get:columnDef.fieldType]@@(@@[get:columnDefs.tableDef.className]@@.@@[get:columnDef.shortColumnName]@@));
	]@@
		return @@[lowerFirst:@@[get:tableDef.className]@@]@@;
	}

}
]@@
