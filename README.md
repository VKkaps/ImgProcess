# ImgProcess
Identifying features in JPG or PNG images.  Note: Currently, if the image is too dark or too large (>1Mb), program may crash with StackOverflow error.

To run with Docker:

docker run --rm -it -p 8080:8080 vkapustin/img-proc:tomcat

Chrome webpage: http://localhost:8080/ImgProcess/
