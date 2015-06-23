copy .\export.bat \Projects\Codequick\export.bat 
copy .\export.bat \Projects\Codequick\export-sql.bat 
copy .\build.bat \Projects\Codequick\build.bat 
copy ..\target\codequick-1.0.0-jar-with-dependencies.jar \Projects\Codequick\codequick.jar 
xcopy /E /I ..\templates \Projects\Codequick\templates
xcopy /E /I ..\config \Projects\Codequick\config
