# ImgProcess
Finding features in JPG or PNG images as fast as possible.  Currently designed for text-based images, with a future goal of being able to identify letters.

To run with Docker:

docker run --rm -e CATALINA_OPTS="-Xms2048m" -it -p 8080:8080 vkapustin/img-proc:2.0

Chrome webpage: http://localhost:8080/ImgProcess/


Current timing results:

![Timing pic](https://i.imgur.com/iF5eRQY.png)


