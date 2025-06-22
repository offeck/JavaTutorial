@echo off
echo ===========================================
echo    JAVA DEBUGGING GAME - LAUNCHER
echo ===========================================
echo.
echo Which stage would you like to run?
echo 1. Warmup (Basic Java concepts)
echo 2. Stage 2 (Prime algorithms and arrays)
echo 3. Stage 3 (Functions, sorting and strings)
echo.
set /p choice="Enter your choice (1, 2, or 3): "

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
) else if "%choice%"=="3" (
    echo.
    echo Compiling stage_3.java...
    javac "stage_3.java"
    if %errorlevel% equ 0 (
        echo Compilation successful! Starting Stage 3...
        echo.
        java stage_3
    ) else (
        echo Compilation failed. Please check for errors.
    )
) else (
    echo Invalid choice. Please run the script again and choose 1, 2, or 3.
)

echo.
pause
