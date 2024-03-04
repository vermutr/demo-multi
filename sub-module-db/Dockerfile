FROM openjdk:17-jdk-alpine

COPY "build/libs/sub-module-db-0.0.1-SNAPSHOT.jar" /db.jar

ENTRYPOINT ["java","-jar","/db.jar"]
