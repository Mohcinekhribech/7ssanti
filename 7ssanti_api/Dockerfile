# Use the official OpenJDK 21 image as the base image
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the entire project into the container
COPY . .

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose the port your application will run on
EXPOSE 8080

# Start the application
CMD ["java", "-jar", "target/hssanti-0.0.1-SNAPSHOT.jar"]