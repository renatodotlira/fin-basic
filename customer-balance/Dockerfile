FROM openjdk:8-jdk-alpine
EXPOSE 8383
ADD /target/customer-balance-0.0.1-SNAPSHOT.jar customer.jar
ENTRYPOINT ["java", "-jar", "customer.jar"]