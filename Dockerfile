#FROM maven as build
#
#WORKDIR /app
#
#COPY . .
#
#RUN  mvn clean package -DskipTests

FROM openjdk:11.0.8-slim-buster

WORKDIR /app

#COPY --from=build "/app/target/api-exec.jar" .

COPY target/api.jar .

CMD java -jar api.jar

