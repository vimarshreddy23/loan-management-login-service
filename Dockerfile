# select parent image
FROM maven:3.5-jdk-8-alpine
 
# copy the source tree and the pom.xml to our new container
COPY ./ ./
 
# package our application code
RUN mvn clean package
 
# set the startup command to execute the jar
CMD ["java", "-jar", "target/loan-management-login-service.jar"]
