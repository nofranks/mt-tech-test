# Matillion Tech Test Solution

This repository contains solutions for technical tests 1 and 2. All solutions are maven modules that provide a standalone executable jars containing all required dependencies when packaged. Clone the repository into an IDE of your choice.

## Test 1

This application takes the two strings below and compares the characters at each point in the strings respectively. The strings are 23 characters long and share a single character, resulting in a reponse of 22

* "Matillion Tech Test ..n"
* "Techtest from Matillion"

To run in IDE:
* Execute main method in org.olly.matillion.test1.Application
To run as jar:
* From the repository root director, change directory to 'test1'
* Run ```mvn package```
* Run ```java -jar target/test-1-1.0-SNAPSHOT-jar-with-dependencies.jar```

## Test 2

This application takes a department, pay type and education level from the user and executes a select query on the provided database, logging the result of the query to the console. The following assumptions have been made:
* The desired output of the query is the contents of the ```employee``` table
* The value for the department parameter is the value stored in ```departments.department_description``` table as opposed to the department_id column.

### test-2 JDBC Implementation

This solution assumes a mySql database is available at ```dbc:mysql://localhost:3306/foodmart``` with username ```root``` and empty password. These values can be overwritten from the command line with the following system properties:
* foodmart.db.url
* foodmart.db.username
* foodmart.db.password
