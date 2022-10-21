# Sort Manager

## Description
A program that will allow a user to sort a randomised array.
The user will then be able to compare their random array, with the sorted one 
and observe performance speed based on selected sorting algorithm. 

    
## Task
[Task](TASK.md)

## Setup

CMD
```
// Open project directory
cd sort-manager/

// Compile classes
mvn compile

// Create JAR file
mvn package

// Run Sort manager
java -jar target/*.jar

```


## Usage
The general flow of the application is:
- The user is presented with a number of sort algorithms to choose from.
- Decision is given via the command line.
- The program will then ask for the length of an array again via the command line (max 1000 not 0).
- The program should then output:
    - The unsorted randomly generated array (values should be between 0 and 1000)
    - The sorting algorithm used
    - The sorted array after the algorithm has been executed
      

