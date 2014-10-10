@echo off
echo copy .eclipse_clean to eclipse
xcopy .eclipse_clean eclipse\ /E /D /Y > .tmp
del .tmp
attrib +H .eclipse_clean
echo gradlew.bat setupDecompWorkspace eclipse
gradlew.bat setupDecompWorkspace eclipse