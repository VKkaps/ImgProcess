FROM tomcat:9.0.14-jre8-slim

MAINTAINER vkapustin

COPY /target/ImgProcess.war /usr/local/tomcat/webapps/ImgProcess.war

CMD ["catalina.sh", "run"]
