FROM openjdk:11-jdk-slim
COPY target/battini-0.0.1-SNAPSHOT.jar api.jar
ENTRYPOINT ["java","-jar","/api.jar"]
