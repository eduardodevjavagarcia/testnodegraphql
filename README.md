# Simple Spring Boot Project
Spring Boot Project to Test the Node Project with GraphQL

# Description
This Spring Boot project was created to test the Node project with GraphQL. However, it can also be used as an example to create your own project.

# Pre Requirements
You have installed Java version 8 on your computer.

# Initializing the Project
Clone the project with command: **git clone** https://github.com/eduardodevjavagarcia/testnodegraphql.git After cloning the project, you should go to the folder where the file is called pom.xml. In this folder you will have to execute the commands:
- mvn clean spring-boot:run

# Database H2
This application is standalone. To access the H2 database, use the url: http://localhost:9090/h2-console <br />
**Note:** as the property **ddl-auto**, in the file **application.yml** is set to **create-drop**, the database will be created and deleted every time it starts the app.

# Main References
- http://spring.io/projects/spring-boot
- https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html
