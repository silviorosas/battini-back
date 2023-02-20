FROM openjdk:11-jdk-slim
COPY target/battini-0.0.1-SNAPSHOT api.jar
ENTRYPOINT ["java","-jar","/api.jar"]
