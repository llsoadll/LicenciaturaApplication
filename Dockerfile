FROM eclipse-temurin:17-jdk-alpine
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","target/licenciatura-0.0.1-SNAPSHOT.jar"]


