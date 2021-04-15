FROM adoptopenjdk/openjdk11:alpine-jre
#FROM amazoncorretto:11
COPY target/sasviewer-*.jar /app.jar
EXPOSE 8080
CMD java ${JAVA_OPTS} -jar /app.jar
