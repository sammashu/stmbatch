STM SIMPLIFY BATCH
===================
More info on STM data go to [http://www.stm.info/en/about/developers] check section OPEN DATA.<br>
This batch convert data from cvs file and insert into a mongodb database.<br>
The Job chain every Step, the first phase delete de collection and Second phase insert in bulk.<br>

###Note
classpath resources/data contain version of exporting data convert into csv file by default stm <br>
give file with extention of .txt we need to use excel to import it into csv format for new update.<br>

DB MONGO
========
#####Custom path DB use to start mongodb you can change the path for your need. <br>
example: "C:\Program Files\MongoDB\Server\4.0\bin\mongod.exe" --dbpath C:\DEVDB\stmsimplify <br>
More info at [https://docs.mongodb.com/guides/server/install/]

check <b>application.properties</b> to configure to your local mongodb<br>
by default it set to use database with name <b>stmsimplify</b> don't forget to create that database when you install mongo db<br>

#####Useful command in mongo db
navigate to mongodb directory to launch <b>mongo.exe</b> unless you have bind it has a variable system.<br>

- use |your db name| -> switching database
- db.dropDatabase()
- db.|your collection|.find(|can use query here|) 
- DBQuery.shellBatchSize = |number row|  -> use to set how many document you want to see default 20

LIBRARY USE OUTSIDE OF SPRING
=============================

- [https://mvnrepository.com/artifact/org.apache.commons/commons-lang3]
- [https://mvnrepository.com/artifact/org.projectlombok/lombok]

SETUP
======
- Java 8 +
- MongoDB 
- Maven

Contributors
------------
- Alexson Sanon Pel