# Alpine Linux with OpenJDK JRE
FROM adoptopenjdk/openjdk11:latest

# Copy war file
COPY spring-boot-rest-api-0.0.1-SNAPSHOT.jar /spring-boot-rest-api.war

# run the app
CMD ["java", "-jar", "/spring-boot-rest-api.war"]

