FROM adoptopenjdk/openjdk11:latest
COPY loja-virtual-0.0.1-SNAPSHOT.jar app.jar
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]