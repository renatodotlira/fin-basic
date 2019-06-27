FROM openjdk:8-jdk-alpine
EXPOSE 8282
ADD /target/purchase-1.jar purchase.jar
ENTRYPOINT ["java", "-jar", "purchase.jar"]