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
Essa aplicação é standalone. Para acessar o banco de dados H2, use a url: http://localhost:9090/h2-console
**Observação:** como a propriedade **ddl-auto**, no arquivo **application.yml** está com o valor **create-drop**, o banco de dados será criado e apaga toda vez que iniciar a aplicação.

# Main References
- http://spring.io/projects/spring-boot
- https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html
