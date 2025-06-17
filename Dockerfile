# Use the official OpenJDK image as the base
FROM openjdk:17-jdk-slim
 
# Set the working directory inside the container
WORKDIR /app
 
# Copy the application war file to the container
COPY target/BookManagement-0.0.1-SNAPSHOT.war /app/BookManagement-0.0.1-SNAPSHOT.war
 
# Expose the port your application runs on
EXPOSE 8090
 
# Define the entry point for running the application
CMD ["java", "-war", "BookManagement-0.0.1-SNAPSHOT.war"]