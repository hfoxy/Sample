#!/bin/sh

mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent package sonar:sonar \
    -Dsonar.host.url=https://sonarcloud.io \
    -Dsonar.organization=hfoxy-github \
    -Dsonar.login=8ea0a0c2b193851de1d5379d6469e948c11bc225
