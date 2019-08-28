#!/bin/bash

docker run -it --rm --name connect-five-backend-builder \
    -v "$PWD":/usr/src/app -v "$HOME"/.m2:/root/.m2 \
    -w /usr/src/app maven:3.6.1-jdk-12 mvn clean install