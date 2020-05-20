FROM openjdk:8
ADD target/lab6.jar lab6.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "lab6.jar"]