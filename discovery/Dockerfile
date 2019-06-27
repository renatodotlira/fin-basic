FROM openjdk:8-jdk-alpine
EXPOSE 8010
ADD /target/eureka-service-discovery-1.jar eureka-service-discovery.jar
ENTRYPOINT ["java", "-jar", "eureka-service-discovery.jar"]