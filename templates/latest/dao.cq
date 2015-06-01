@@[template:DAO Template]@@
@@[project:Codequick Sample]@@
@@[version:1.0]@@
@@[author:Marcelo Torres]@@
@@[licence:GNU GPL 3]@@

@@[fileType:Java]@@
@@[fileModule:ejb]@@
@@[filePath:@@[getVar:daoPackageName]@@]@@
@@[filePrefix:]@@
@@[fileSufix:Dao.java]@@

@@[content:
package @@[getVar:daoPackageName]@@;

import java.util.List;

import com.codequick.common.data.DAOBase;
import @@[getVar:modelPackageName]@@.@@[get:tableDef.className]@@;

public interface @@[get:tableDef.className]@@DAO extends DAOBase {

	@@[get:tableDef.className]@@ findByID(final @@[get:tableDef.className]@@ @@[lowerFirst:@@[get:tableDef.className]@@]@@);
	List<@@[get:tableDef.className]@@> listAll();
	int insert(final @@[get:tableDef.className]@@ @@[lowerFirst:@@[get:tableDef.className]@@]@@);
	int delete(final @@[get:tableDef.className]@@ @@[lowerFirst:@@[get:tableDef.className]@@]@@);
	int update(final @@[get:tableDef.className]@@ @@[lowerFirst:@@[get:tableDef.className]@@]@@);

}
]@@
