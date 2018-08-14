FROM tomcat:8.0.20-jre8

MAINTAINER vkapustin

COPY /target/ImgProcess.war /usr/local/tomcat/webapps/ImgProcess.war

CMD ["catalina.sh", "run"]