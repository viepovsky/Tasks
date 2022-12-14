call runcrud.bat
if "%ERRORLEVEL%" == "0" goto runbrowser
echo.
echo Cannot call runcrud.bat - breaking work
goto fail

:runbrowser
TIMEOUT 10
start chrome /new-window http://localhost:8080/crud/v1/tasks
if "%ERRORLEVEL%" == "0" goto end
echo Cannot open browser
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.