FROM openjdk:17-alpine

WORKDIR app

COPY . .

EXPOSE 8080

CMD ["java", "-jar","target/managerTask-0.0.1-SNAPSHOT.jar"]