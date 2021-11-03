# Movies Database
Java application to interact with mysql database using JDBC

### Setup
Requirements: Maven, Java 8, MySQL

Creation of database is done out of band and the database configuration can be modified in Constants.java file

### Build
From the root directory build the project using maven
```mvn clean install```

### Run
```java -jar target/MovieDB-1.0-SNAPSHOT-jar-with-dependencies.jar```

### Functionalities
1. Create db table
2. Add entry to db table
3. Fetch all movie entries
4. Fetch all movie entries with a filter on actor name
5. Fetch all movie entries with a filter on actress name
6. Fetch all movie entries with a filter on year of release
