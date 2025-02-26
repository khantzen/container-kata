# Quote picker api

This api return quote from fortune when asked

## How to run

Project is currently running with Java 17.

Using maven and running command

```shell
mvn clean install
```

You'll get `./target/backend-1.0-SNAPSHOT-jar-with-dependencies.jar` file created.

You can run the application running

```shell
java -jar ./target/backend-1.0-SNAPSHOT-jar-with-dependencies.jar
```

You can now check your api is running http://localhost:4567/api/v1/categories

## Endpoints

Api listen on port 4567

> /api/v1/categories *List all quote categories*

> /api/v1/allQuotes *List all quotes in the project*

> /api/v1/randomQuoteIn/:category *Return a random quote for the given category* 
