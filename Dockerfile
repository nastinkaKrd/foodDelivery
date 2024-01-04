FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/food_delivery-0.0.1-SNAPSHOT.jar /app/food_delivery-0.0.1-SNAPSHOT.jar

EXPOSE 8082

CMD ["java", "-jar", "/app/food_delivery-0.0.1-SNAPSHOT.jar"]