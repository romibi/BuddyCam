@echo off
echo copy .eclipse_clean to eclipse
xcopy .eclipse_clean eclipse\ /E /D /Y > .tmp
del .tmp
attrib -H eclipse
attrib +H .*
attrib +H .settings
attrib +H .gradle
attrib +H *.sh
attrib +H gradlew
attrib -H .gitignore
echo gradlew.bat setupDecompWorkspace eclipse
gradlew.bat setupDecompWorkspace eclipse