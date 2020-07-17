FROM openjdk:8
WORKDIR /
COPY /target/user-0.0.1-SNAPSHOT.jar BasicAuth.jar
CMD ["java", "-jar", "BasicAuth.jar"]