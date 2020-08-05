FROM maven:3.6.3-openjdk-11-slim as build

WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ /app/src/
RUN mvn clean package -DskipTests

FROM openjdk:11.0.8-jre


WORKDIR /app

COPY --from=build "/app/target/api.jar" api.jar

CMD java -jar api.jar