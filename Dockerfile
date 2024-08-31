FROM openjdk:17-jdk-alpine



COPY ./target/spring-intro.jar app.jar
ENTRYPOINT ["java", "-jar","/app.jar"]