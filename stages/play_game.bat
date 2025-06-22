@echo off
echo ===========================================
echo    JAVA DEBUGGING GAME - LAUNCHER
echo ===========================================
echo.
echo Which stage would you like to run?
echo 1. Warmup (Basic Java concepts)
echo 2. Stage 2 (Prime algorithms and arrays)
echo 3. Stage 3 (Functions, sorting and strings)
echo 4. Stage 4 (Recursion mastery)
echo 5. Stage 5 (Object-oriented programming)
echo 6. Stage 6 (Advanced OOP and inheritance)
echo.
set /p choice="Enter your choice (1, 2, 3, 4, 5, or 6): "

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
) else if "%choice%"=="4" (
    echo.
    echo Compiling stage_4.java...
    javac "stage_4.java"
    if %errorlevel% equ 0 (
        echo Compilation successful! Starting Stage 4...
        echo.
        java stage_4
    ) else (
        echo Compilation failed. Please check for errors.
    )
) else if "%choice%"=="5" (
    echo.
    echo Compiling stage_5.java...
    javac "stage_5.java"
    if %errorlevel% equ 0 (
        echo Compilation successful! Starting Stage 5...
        echo.
        java stage_5
    ) else (
        echo Compilation failed. Please check for errors.
    )
) else if "%choice%"=="6" (
    echo.
    echo Compiling stage_6.java...
    javac "stage_6.java"
    if %errorlevel% equ 0 (
        echo Compilation successful! Starting Stage 6...
        echo.
        java stage_6
    ) else (
        echo Compilation failed. Please check for errors.
    )
) else (
    echo Invalid choice. Please run the script again and choose 1, 2, 3, 4, 5, or 6.
)

echo.
pause
