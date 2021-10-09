# Bahir Employee Data Migration Project<!-- TOC depthFrom:1 depthTo:6 withLinks:1 updateOnSave:1 orderedList:0 -->

* [Bahir Employee Data Migration project](#bahir-employee-data-migration-project)
* [Project Purpose](#project-purpose)
* [Project Instructions](#project-instructions)
  * [Block Diagram](#block-diagram)
* [Employee data migration plan](#employee-data-migration-plan)
  * [Driver class](#driver-class)
  * [Display manager](#display-manager)
  * [Employee DAO info](#employee-dao-info)
  * [Employee DAO interface](#employee-dao-interface)
  * [Logging manager](#logging-manager)
  * [Cleaning manager](#cleaning-manager)
  * [Employee Process](#employee-process)
  * [Employee DAO concrete class](#employee-dao-concrete-class)
  * [JDBC single thread](#jdbc-single-thread)
  * [JDBC multi thread](#jdbc-multi-thread)
	* [Design process](#design-process)
  * [Agile](#agile)
  * [Retrospective](#retrospective)
	* [Comparison between the threads](#comparison-between-the-threads)
	* [Main Java skills demonstrated (outside all the basics)](#main-java-skills-demonstrated-outside-all-the-basics)
	* [GIT REPO LINKS](#git-repo-links)

<!-- /TOC -->

### Project Purpose

- **To read data from a CSV file (provided), parse it, populate objects and add to a collection.**
- **To efficiently write the data from the objects to a relational database using JDBC.**
- **To demonstrate good programming practices in OOP, SOLID, design patterns, testing, logging, etc.**

### Project Instructions
- First make sure that the connection is set to mySQL as seen in the image below and
please use your information such as password instead
![mySQL](/readmeImages/imageForMysql.png)
- next make sure to either create a scheme in mySql workbench called "myemployees"
or you can rename the myemployees to another scheme instead
- When you run the program you will be prompted to pick either single threading or multi threading
- Both options will take a couple of seconds to process and then you will get a prompt for some simple SQL queries or if you want to exit the program.

#### Block Diagram
![Block diagram](/readmeImages/BlockDiagram.png)

### Employee data migration plan

#### Driver class
- [x] User interface gets displayed
- [x] Minimal amount of code possible
- [x] Handles exceptions where needed
- [x] Takes user input for picking thread

#### Display manager
- [x] showcase the menu as a private instance
- [x] include getters

#### Employee DAO info
- [x] create private instance of each variable needed
- [x] include getters and setters
- [x] create a constructor for use outside

#### Employee DAO interface
- [x] create the methods that will be used for displaying the data

#### Logging manager
- [x] create a vast amount of logs needed in the program

#### Cleaning manager
- [x] iterate over the whole csv file
- [x] separate the duplicates and the unique
- [x] display the time taken and size of both lists

#### Employee Process
- [x] split the rows into their respected value
- [x] format the data to the correct type
- [x] make sure the SQL date is used

#### Employee DAO concrete class
- [x] create the output for each query using the DAO interface
- [x] showcase the use of streams
- [x] showcase the use of lambda

#### JDBC single thread
- [x] correctly drop and create the employees table
- [x] insert all the unique rows into the table
- [x] output the time taken

#### JDBC multi thread
- [x] correctly drop and create the employees table
- [x] split the list of unique rows into 2 lists
- [x] insert all the unique rows into the table
- [x] output the time taken

## Design process
#### Agile
I used the four principles of agile again  making sure I created a viable project that was handled properly.

#### Retrospective
The project started slow at the beginning mainly because I had different ways of implementing the solution this caused me to waste some time so I wish I did some better planning before I started.

The end implementation is well done as I have added all features necessary although I did some basic things in using streams and lambda and in the future maybe explore those in more depths rather then doing some basics.

Also to note why I choose 2 threads for multi threading was mainly because I would get errors if I did more then 2, such as the program would get stuck in run time. Due to time constraints instead of fixing I decided to go with 2 threads as it still showcases multi threading and it would save me time from debugging and overall still produces a very good write time,

Overall this project has taught me a lot of new skills and concepts which resulted in a enjoyable but also challenging project yet delivers a high quality project.

## Comparison between the threads
![Single Thread](/readmeImages/singleThreadTime.png)

![MultiThread](/readmeImages/MultiThreading.png)


## Main Java skills demonstrated (outside all the basics)
- OOP
- Design Patterns (MVC, DAO)
- JDBC
- mySQL(using it through java)
- Multi threading
- Lambdas (basic skills shown)
- Streams (basic skills shown)
- SOLID Principles
- Interface
- Exception handling
- Logging
- TDD/ Unit Testing

## GIT REPO LINKS
**REPO** https://github.com/btara99/EmployeeDataMigrationProject
