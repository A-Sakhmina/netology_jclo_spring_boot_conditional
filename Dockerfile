FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/springBootApplication-0.0.1-SNAPSHOT.jar devapp.jar
ENTRYPOINT ["java","-jar","/devapp.jar"]