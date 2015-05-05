@@[template:Service Template]@@
@@[project:Codequick Sample]@@
@@[version:1.0]@@
@@[author:Marcelo Torres]@@
@@[licence:GNU GPL 3]@@

@@[fileType:Java]@@
@@[fileModule:common]@@
@@[filePath:@@[getVar:servicePackageName]@@]@@
@@[filePrefix:]@@
@@[fileSufix:Service.java]@@

@@[content:
package @@[getVar:servicePackageName]@@;

import java.util.List;

import com.codequick.common.service.ServiceBase;
import @@[getVar:modelPackageName]@@.@@[get:tableDef.className]@@;

public class @@[get:tableDef.className]@@Service extends ServiceBase {

	@@[get:tableDef.className]@@ findByID(final @@[get:tableDef.className]@@ @@[lowerFirst:@@[get:tableDef.className]@@]@@);
	List<@@[get:tableDef.className]@@> listAll();
	int insert(final @@[get:tableDef.className]@@ @@[lowerFirst:@@[get:tableDef.className]@@]@@);
	int delete(final @@[get:tableDef.className]@@ @@[lowerFirst:@@[get:tableDef.className]@@]@@);
	int update(final @@[get:tableDef.className]@@ @@[lowerFirst:@@[get:tableDef.className]@@]@@);
	
}
]@@
