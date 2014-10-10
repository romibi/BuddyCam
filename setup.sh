#!/bin/bash
echo copy .eclipse_clean to eclipse
cp -R .eclipse_clean/ eclipse
echo ./gradlew setupDecompWorkspace
./gradlew setupDecompWorkspace
echo ./gradlew eclipse
./gradlew eclipse