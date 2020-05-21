FROM openjdk:11
EXPOSE 8081
CMD ["java", "-Dspring.profiles.active=cloud", "-jar", "accessing-data-mongodb-0.0.1-SNAPSHOT.jar"]

COPY target/accessing-data-mongodb-0.0.1-SNAPSHOT.jar .