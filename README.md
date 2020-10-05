# How to start the application

## Starting backend

### Command Prompt

Need [Maven](https://maven.apache.org/install.html) installed to use the command `mvn clean install`.

Need [Java 11](https://jdk.java.net/archive/) in OS environment variables.

Than just execute the [bat file](desafio-backend/start-back.bat) for Windows (Sorry but i don't finish)

### DB

it is necessary to have 4 bases in postgres, the bases are configured in the application.yml files of each microservice: basea, baseb, basec and challenge.

it is necessary to create a user as it is in the configuration file of each microservice.

When starting each microservice it will create the tables in the configured database and with some items for testing.

### IDE

Need to configure Java 11 as prefered JDK in preferences.

Need to install [Lombok](https://projectlombok.org/) in the IDE.

Run Maven commands `clean` and `install`.

You will need the 8080, 8081, 8082, 8083,8084,8085 ports available

Start Discovery microservice first and then it doesn't matter the order of the next ones

### SWAGGER DOC

After the application has started, can use on port 8080/gateway/nameService/swagger-ui.htmt.

Name Services: discovery, gateway, auth, debts, consult-cpf, credit-score

### POSTMAN

Endpoints [Postman Collection](Desafio.postman_collection.json)
