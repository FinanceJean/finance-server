FROM openjdk:11-jre
ADD target/api-finance.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
