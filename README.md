# CampusCoffee (SE SS2025)

## Spring Boot Web Application

### Build and start application dev profile activated

**Note:** In the `dev` profile, the repositories are cleared before startup and the initial data is loaded (see [`LoadInitialData.java`](https://github.com/se-ubt/ase24-taskboard/blob/main/application/src/main/java/de/unibayreuth/se/taskboard/LoadInitialData.java)).

Build application:
```shell
mvn clean install
```

Start Postgres docker container:
```shell
docker run -d -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 postgres:17-alpine
```

Start application (data source configured via [`application.yaml`](application/src/main/resources/application.yaml)):
```shell
cd application
mvn spring-boot:run -D"spring-boot.run.profiles=dev"
```

### REST requests (POS)

#### Get POS

All POS:
```shell
curl http://localhost:8080/api/pos
```
POS by ID:
```shell
curl http://localhost:8080/api/pos/1 # add valid POS id here
```

#### Create POS

```shell
curl.exe --% -H "Content-Type: application/json" --request POST --data "{\"name\":\"New Café\",\"description\":\"\",\"type\":\"CAFE\",\"campus\":\"MAIN\",\"street\":\"Teststraße\",\"houseNumber\":\"99\",\"postalCode\":12345,\"city\":\"Bayreuth\"}" "http://localhost:8080/api/pos"
```

#### Update task

Update title and description:
```shell
curl.exe --% -H "Content-Type: application/json" --request PUT --data "{\"id\":7,\"name\":\"Stadtbaeckerei Schaller\",\"description\":\"Baeckerei mit anliegender Metzgerei, Drogerie und Supermarkt\",\"type\":\"CAFE\",\"campus\":\"MAIN\",\"street\":\"Nuernberger Straße\",\"houseNumber\":\"3b\",\"postalCode\":\"95448\",\"city\":\"Bayreuth\"}" "http://localhost:8080/api/pos/7" # set correct task id here and in the body
```
