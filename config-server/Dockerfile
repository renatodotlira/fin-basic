FROM openjdk:8-jdk-alpine
EXPOSE 8001
ADD /target/config-server-1.jar config-server.jar
ENTRYPOINT ["java", "-jar", "config-server.jar"]