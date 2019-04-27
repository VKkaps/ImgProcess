# ImgProcess
Experimental Java program for locating, grading, and classifying AlphaNumeric characters in JPG or PNG images as fast as possible. 
I am using a WebPage as a UI and a Servlet running on a Tomcatv9.0 server to handle requests.

Example:

![Example ImgProc pic](https://imgur.com/Z5ofc5a.png)

To run with Docker:

docker run --rm -e CATALINA_OPTS="-Xms2048m" -it -p 8080:8080 vkapustin/img-proc:3.2

Chrome webpage: http://localhost:8080/ImgProcess/

Current timing results:

![Timing pic](https://i.imgur.com/iF5eRQY.png)


