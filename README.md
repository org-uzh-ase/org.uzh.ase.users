# User microservice
Microservice responsible for keeping track of player scores. For an API specification see [Swagger](https://app.swaggerhub.com/apis-docs/ltoedt/ASE/0.1).

## Getting started
### Prerequisites
- Java 11
- Maven
- Running MongoDB, to define connection details see `application-local.properties` if you are running JAR, or `application-cloud.properties` if you are using containers.


### Running
We do not provide precompiled JARs, but you can use our pre-built container from [DockerHub](https://hub.docker.com/repository/docker/vladmasarik/user). If you are looking for JAR file, you need to build one yourself, see [building guide](##Building).
After you are done with building simply execute the JAR, for example:
```
java -jar target/accessing-data-mongodb-0.0.1-SNAPSHOT.jar
```
or in case of a container:
```
docker run <container tag>
```


### Building
#### JAR
Using Maven, simply execute:
```
mvn package
```

#### Container
Build a JAR, then build a container using the 
```
docker build -t <container tag> -f user.Dockerfile .
```

### Testing
Tests are executed using simple JAR version, so MongoDB configuration is used from `application-local.properties` file.
To execute tests use Maven:
```
mvn test
```
