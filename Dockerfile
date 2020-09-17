FROM openjdk:8

EXPOSE 8000

ADD target/loan-management-login-service.jar loan-management-login-service.jar

ENTRYPOINT ["java","-jar","loan-management-login-service.jar"]
