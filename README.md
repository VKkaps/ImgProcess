# ImgProcess
Identifying features in JPG or PNG images as fast as possible.  Designed for text based images, with a future goal of being able to identify letters.

To run with Docker:

docker run --rm -e CATALINA_OPTS="-Xms2048m" -it -p 8080:8080 vkapustin/img-proc:tomcat

Chrome webpage: http://localhost:8080/ImgProcess/
