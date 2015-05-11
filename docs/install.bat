copy .\export.bat c:\Projects\Codequick\export.bat 
copy .\build.bat c:\Projects\Codequick\build.bat 
copy ..\target\codequick-1.0.0-BETA-jar-with-dependencies.jar c:\Projects\Codequick\codequick.jar 
xcopy /E /I ..\templates \Projects\Codequick\templates
xcopy /E /I ..\config \Projects\Codequick\config
