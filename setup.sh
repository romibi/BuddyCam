#!/bin/bash
cp -R .eclipse_clean/ eclipse
./gradlew setupDecompWorkspace
./gradlew eclipse