FROM openjdk:12-alpine AS build
COPY . /src/app
WORKDIR /src/app
CMD "./mvnw" "clean" "install" "verify"

FROM openjdk:12-alpine AS run
WORKDIR /app
COPY --from=build /src/app/target .
EXPOSE 8080
CMD "java" "-jar c5_back.jar"