# sas7bdat-viewer
Quick and dirty app created with Spring Boot and [Parso](https://github.com/epam/parso) to view the content of sas7bdat files.

# Run as a Docker container

    docker build -t sasviewer .
    docker run -p=8080:8080 sasviewer

# Acknowledgements
Spring Boot: https://spring.io/projects/spring-boot

Parso: https://github.com/epam/parso

Spring Boot: [Uploading Files](https://spring.io/guides/gs/uploading-files/)

I followed this tutorial on how to deploy a spring boot app on AWS Elastic Beanstalk.

https://www.youtube.com/watch?v=EtDSJRdpJM4&feature

# License
This project is licensed under the [MIT 2.0 License](LICENSE).
