# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk


# Set the working directory
WORKDIR /app

# Copy the Spring Boot application JAR file into the container
COPY target/barber-shop-0.0.1-SNAPSHOT.jar app.jar

# Copy your application.properties (or application.yml) into the container
COPY src/main/resources/application.properties application.properties

# Expose the port that your Spring Boot application is running on
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "app.jar", "--spring.config.name=application"]