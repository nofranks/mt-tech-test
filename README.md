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
