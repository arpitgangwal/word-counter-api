FROM openjdk:8
EXPOSE 8080
ADD target/word-counter-api.jar word-counter-api.jar
ENTRYPOINT ["sh", "-c","java  -jar /word-counter-api.jar"]