# Matillion Tech Test Solution

This repository contains solutions for technical tests 1 and 2. All solutions are maven modules that provide a standalone executable jars containing all required dependencies when packaged. Clone the repository into an IDE of your choice.

## Test 1

This application takes the two strings below and compares the characters at each point in the strings respectively. If two arguments are provided from the command line, they will be used for the comparision, otherwise defaults will be used. The default strings are 23 characters long and share a single character, resulting in a reponse of 22 differences.

* "Matillion Tech Test ..n"
* "Techtest from Matillion"

To run in IDE:
* Execute main method in ```org.olly.matillion.charactercomparator.Application```
To run as jar:
* From the repository root directory, change directory to 'test1'
* Run ```mvn package```
* Run ```java -jar target/test-1-1.0-SNAPSHOT-jar-with-dependencies.jar "arg1" "arg2"```

## Test 2

This application takes a department, pay type and education level from the user and executes a select query on the provided database, logging the result of the query to the console. The following assumptions have been made:
* The desired output of the query are the full rows of the ```employee``` table matching the query
* The value for the department parameter is the value stored in ```departments.department_description``` table as opposed to the department_id column.

For each solution, in the console/terminal you will be prompted for a department description, pay type and education level. The query will then be executed with these values. Alternatively, these values can be provided as program arguments on the command line in the order above. If three arguments are provided, the program will try to execute the query with these values.

Sample input: ```"HQ General Management" "Monthly" "Bachelors Degree"```
### test-2 JDBC Implementation

NB: The integration tests for this implementation require the presence of the sample database that was provided. I have not had time to implement an in-memory solution to test the query against during the build. The unit tests are carried out on a mock of the FoodmartService and the integration tests will only be executed if the verify target is included in the mvn command.

This solution assumes a mySql database is available at ```jdbc:mysql://localhost:3306/foodmart``` with username ```root``` and empty password. These values can be overwritten from the command line with the following system properties:
* foodmart.db.url
* foodmart.db.username
* foodmart.db.password

To run in ide:
* Execute main method in ```org.olly.matillion.foodmart.FoodmartApplication``` in test-2 module
To run as jar:
* From the repository root director, change directory to 'test-2'
* Run ```mvn package```
* Run ```java -jar target/test-2-0.0.1-SNAPSHOT-jar-with-dependencies.jar "HQ General Management" "Monthly" "Bachelors Degree"```

### test-2 SpringBoot Commandline Implementation

This solution assumes a mySql database is available at ```jdbc:mysql://localhost:3306/foodmart``` with username ```root``` and empty password. These values can be overwritten from the command line with the following system properties:
* spring.datasource.url
* spring.datasource.username
* spring.datasource.password

To run in ide:
* Execute main method in ```org.olly.matillion.foodmart.FoodmartApplication``` in test-2-spring module

To run as jar:
* From the repository root director, change directory to 'test-2-spring'
* Run ```mvn package```
* Run ```java -jar target/test-2-0.0.1-SNAPSHOT-jar-with-dependencies.jar "HQ General Management" "Monthly" "Bachelors Degree"```
