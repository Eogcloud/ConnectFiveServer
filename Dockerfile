FROM openjdk:12-alpine
COPY . /src/app
WORKDIR /src/app
CMD "./mvnw" "clean" "install" 