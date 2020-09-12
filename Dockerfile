FROM java:8

EXPOSE 8080

ADD target/loan-management-login-service.jar loan-management-login-service.jar

ENTRYPOINT ["java","-jar","loan-management-login-service.jar"]


FROM tomcat:8
# Take the war and copy to webapps of tomcat
COPY target/*.war /usr/local/tomcat/webapps/myweb.war