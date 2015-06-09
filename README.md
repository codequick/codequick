# codequick
A quick methody to generate code for CRUD applications.

Database script files to create database structure on PostgreSQL.

Create role, database and schema:
sample-db-create.sql

Create sample model:
sample-model.sql

Commands to create eclipse project, compile, assembly, install, export and build files.

Create eclipse project:
mvn eclipse:eclipse

Compile:
mvn clean install

Generate .jar file with dependencies:
mvn assembly:assembly

Install Codequick on target path:
docs/install.bat

Database driver configuration:
Create the path /Projects/Codequick/drivers
Put the driver into the path above

Change the config.properties setting correctly the follow keys:
db=[one of postgre, sqlserver, oracle - if other, needs to create lang_database.properties]
driverPath=/Projects/codequick/drivers/[driver_file_name]
driverName=[driver name]
connectionUrl=[database url]
userName=[database user]
password=[database password]
schemas=[schema]

Export metadata files:
/Projects/Codequick/export.bat

Build target files:
/Projects/Codequick/build.bat

