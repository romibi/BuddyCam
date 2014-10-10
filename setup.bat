@echo off
echo copy .eclipse_clean to eclipse
xcopy .eclipse_clean eclipse\ /E /D /Y > .tmp
del .tmp
attrib -H eclipse
echo gradlew.bat setupDecompWorkspace
gradlew.bat setupDecompWorkspace
echo gradlew.bat eclipse
gradlew.bat eclipse
pause