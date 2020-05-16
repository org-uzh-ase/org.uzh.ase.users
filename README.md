# User microservice
Microservice responsible for keeping track of player scores. For an API specification see [Swagger](https://app.swaggerhub.com/apis-docs/ltoedt/ASE/0.1).

## Getting started
### Prerequisites
- Java 11
- Maven
- Running MongoDB, to define connection details see `application-local.properties` if you are running JAR, or `application-cloud.properties` if you are using containers. The files are in `src/main/resources`. The database should contain data, that you can import from `src/main/resources/movies`, see [How to import data](##How-to-import-data-into-MongoDB) for more info.


### Running
After you are done with building simply execute the JAR, for example:
```
java -jar target/accessing-data-mongodb-0.0.1-SNAPSHOT.jar
```



### Building
#### JAR
Using Maven, simply execute:
```
mvn package
```

### Testing
Tests are executed using simple JAR version, so MongoDB configuration is used from `application-local.properties` file.
To execute tests use Maven:
```
mvn test
```