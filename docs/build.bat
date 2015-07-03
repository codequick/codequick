echo Export will be run with parameter: %1

if %1.==. goto no_config

java -jar codequick.jar -build -config=%1

goto end

:no_config

java -jar codequick.jar -build

:end
