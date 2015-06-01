@@[template:Model Template]@@
@@[project:Codequick Sample]@@
@@[version:1.0]@@
@@[author:Marcelo Torres]@@
@@[licence:GNU GPL 3]@@

@@[fileType:Java]@@
@@[fileModule:common]@@
@@[filePath:@@[getVar:modelPackageName]@@]@@
@@[filePrefix:]@@
@@[fileSufix:.java]@@

@@[content:
package @@[getVar:modelPackageName]@@;


public class @@[get:tableDef.className]@@ {
	
	// Table name
	public static final String TABLE = "@@[get:tableDef.schema]@@@@[if:@@[get:tableDef.schema]@@ ne null@@;.@@;]@@@@[get:tableDef.name]@@";
	
	// Fields names
	@@[loop:tableDef.columnDefs@@;
	public static final String @@[get:columnDef.shortColumnName]@@ = "@@[get:columnDef.propertyName]@@";
	]@@
	
	@@[loop:tableDef.columnDefs@@;
	private @@[get:columnDef.propertyType]@@ @@[get:columnDef.propertyName]@@;
	]@@

	@@[loop:tableDef.columnDefs@@;
	public @@[get:columnDef.propertyType]@@ get@@[upperFirst:@@[get:columnDef.propertyName]@@]@@() {
		return @@[get:columnDef.propertyName]@@;
	}

	public void set@@[upperFirst:@@[get:columnDef.propertyName]@@]@@(@@[get:columnDef.propertyType]@@ @@[get:columnDef.propertyName]@@) {
		this.@@[get:columnDef.propertyName]@@ = @@[get:columnDef.propertyName]@@;
	}
	
	]@@
}
]@@
