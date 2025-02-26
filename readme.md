# Notification Requests Application 
##  Local Setup and Run Guide

### Prerequisites
- Java 17 or later
- Git

### Steps to Run Locally

1. Clone the repository:

2. Build the project:
>./mvnw clean install
3. Run the application:
>./mvnw spring-boot:run

4. The application will start running at `http://localhost:8080`

5. Access the Swagger UI for API documentation:
   Open a web browser and go to `http://localhost:8080/swagger-ui/index.html`

6. H2 in memory database is actually configured to be used at runtime. Configuration can be changed in pom.xml. 
7. H2 Console can be accessed at Open a web browser and navigate to `http://localhost:8080/h2-console`
8. On the login page, you'll need to provide the JDBC URL, username, and password.
>JDBC URL: jdbc:h2:mem:testdb

>Username: sa

>Password: (leave empty by default)

### Configuration

- The application uses default Spring Boot configuration.
- To customize, change `application.properties` file.

### Testing

Run the tests using:
>./mvnw test
