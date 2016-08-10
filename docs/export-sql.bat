rem java -cp "drivers\postgresql-9.3-1102-jdbc41.jar" -jar codequick.jar -export
echo Export will be run with parameter: %1

@ECHO OFF

if %1.==. goto no_config

java -Djava.library.path="C:/proj/websphereresources/was/install/mssqlserver/v402206/auth/x64" -jar codequick.jar -export -config=%1

goto end

:no_config

java -Djava.library.path="C:/proj/websphereresources/was/install/mssqlserver/v402206/auth/x64" -jar codequick.jar -export

:end
