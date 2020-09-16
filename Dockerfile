# select parent image
FROM openjdk:8
 
EXPOSE 8087

ADD target/loan-management-login-service.jar loan-management-login-service.jar

# set the startup command to execute the jar
ENTRYPOINT ["java", "-jar", "loan-management-login-service.jar"]
