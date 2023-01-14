FROM maven:3.6.3-jdk-11 AS build

WORKDIR /build

COPY . .

RUN mvn package -DskipTests

FROM openjdk:11 as production

WORKDIR /app

COPY --from=build /build/target/publish-ms.jar /app/publish-ms.jar

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "publish-ms.jar"]