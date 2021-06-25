to Demonstrate How to Create SpringBoot JPA application uses MySQL Database
 
please check pom, docker-compose.yml for the version

mysql config
		url: 		jdbc:mysql://localhost:3306/testDB --> please create database testDB before using this application
		username : 	root
		password : 	password
		spring.jpa.hibernate.ddl-auto = update --> Auto create table if table is exists


Create MySQL Docker:
docker-compose up -d
 
=================================================== 
SQL Query to create DB :

use testDB;
CREATE T 

===================================================