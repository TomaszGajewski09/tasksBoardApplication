call runcrud.bat
if "%ERRORLEVEL%" == "0" goto runwebbrowser
echo.
echo call runcrud.bat ERROR - breaking work
goto fail

:runwebbrowser
start "" "C:\Program Files\Google\Chrome\Application\chrome.exe" "http://localhost:8080/crud/v1/task/tasks"
if "%ERRORLEVEL%" == "0" goto end
echo.
echo run web browser ERROR - breaking work
goto fail



:fail
echo.
echo There were errors

:end
echo.
echo Work is finished