FROM maven:3.8.4-openjdk-8-slim as build

WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY . .
RUN mvn clean package -DspikTests

FROM openjdk:8-jre-alpine

WORKDIR /app

RUN addgroup --system javauser && adduser javauser -S -s /bin/false -G javauser javauser
RUN chown -R javauser:javauser /app

COPY --from=build /app/target/fib-rest-api-0.0.1-SNAPSHOT.jar /app/app.jar
USER javauser
CMD ["java","-jar","app.jar"]