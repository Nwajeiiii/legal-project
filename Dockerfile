FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Make the Maven wrapper script executable
RUN chmod +x mvnw

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]