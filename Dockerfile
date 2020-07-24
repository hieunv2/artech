FROM maven as build

WORKDIR /app

COPY . .

RUN  mvn clean package -DskipTests

FROM openjdk:11.0.8-slim

WORKDIR /app

COPY target/artech-0.0.1-SNAPSHOT.jar .

CMD java -jar artech-0.0.1-SNAPSHOT.jar