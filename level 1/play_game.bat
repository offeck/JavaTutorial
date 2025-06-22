@echo off
echo ===========================================
echo    JAVA DEBUGGING GAME - LAUNCHER
echo ===========================================
echo.
echo Which stage would you like to run?
echo 1. Warmup (Basic Java concepts)
echo 2. Stage 2 (Prime algorithms and arrays)
echo.
set /p choice="Enter your choice (1 or 2): "

if "%choice%"=="1" (
    echo.
    echo Compiling warmup.java...
    javac "warmup.java"
    if %errorlevel% equ 0 (
        echo Compilation successful! Starting Warmup...
        echo.
        java warmup
    ) else (
        echo Compilation failed. Please check for errors.
    )
) else if "%choice%"=="2" (
    echo.
    echo Compiling stage_2.java...
    javac "stage_2.java"
    if %errorlevel% equ 0 (
        echo Compilation successful! Starting Stage 2...
        echo.
        java stage_2
    ) else (
        echo Compilation failed. Please check for errors.
    )
) else (
    echo Invalid choice. Please run the script again and choose 1 or 2.
)

echo.
pause
