FROM tomcat:9.0.14-jre8-slim

MAINTAINER vkapustin

COPY /target/ImgProcess-3.2.war /usr/local/tomcat/webapps/ImgProcess-3.2.war

CMD ["catalina.sh", "run"]
