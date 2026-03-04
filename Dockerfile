# --- Build stage (Maven tekee jarin) ---
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -B clean package -DskipTests

# --- Run stage (vain Java + jar) ---
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY --from=build /app/target/OTP1_inclass_assignment-1.0-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]