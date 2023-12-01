## Start with a base image containing Java runtime
#FROM openjdk:8-jdk-alpine
#
## Add Maintainer Info
#LABEL maintainer="your-email@example.com"
#
## Add a volume pointing to /tmp
#VOLUME /tmp
#
## Make port 8080 available to the world outside this container
#EXPOSE 8080
#
## The application's jar file
#ARG JAR_FILE=target/system-0.0.1-SNAPSHOT.jar
#
## Add the application's jar to the container
#ADD ${JAR_FILE} system-0.0.1-SNAPSHOT.jar
#
## Run the jar file
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/system-0.0.1-SNAPSHOT.jar"]

#FROM eclipse-temurin:17-jdk-alpine
#VOLUME /tmp
#COPY target/*.jar app.jar
#ENTRYPOINT ["java", "-jar", "/app.jar"]
#EXPOSE 8080

## Stage 1: Build the application
#FROM maven:3.8.4-openjdk-17 as build
#WORKDIR /app
#COPY src src
#COPY pom.xml .
#RUN mvn -f pom.xml clean package
#
## Stage 2: Create the final Docker image
#FROM eclipse-temurin:17-jdk-alpine
#COPY --from=build /app/target/*.jar app.jar
#ENTRYPOINT ["java", "-jar", "/app.jar"]
#EXPOSE 8080


# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
#RUN ./mvnw dependency:resolve

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]
