# User Info Server

This repository contains the source code for the User Info Server, a Spring Boot application designed to manage user information. Below are the necessary steps to start the application, along with the list of dependencies used in the project.

## Dependencies

The User Info Server project utilizes the following dependencies:

1. **Spring Boot Starter Data JPA:** Provides support for Spring Data JPA to interact with the database.
2. **Spring Boot Starter Web:** Sets up the necessary dependencies for building web applications with Spring MVC.
3. **Spring Boot DevTools:** Offers additional development-time features like automatic restarts.
4. **MySQL Connector/J:** Allows the application to connect to a MySQL database.
5. **Project Lombok:** Simplifies the creation of Java classes by reducing boilerplate code.
6. **SpringDoc OpenAPI Starter WebMVC UI:** Integrates the OpenAPI UI into the application to visualize APIs.
7. **SpringDoc OpenAPI UI:** Provides additional support for SpringDoc OpenAPI.
8. **Spring Boot Starter Validation:** Enables validation support in the application.
9. **JavaMail API:** Supports email functionality in the application.
10. **Spring Context Support:** Provides additional support for Spring ApplicationContext.
11. **Spring Boot Starter Mail:** Configures Spring Mail for email sending.
12. **Spring Boot Test:** Offers support for testing Spring Boot applications.
13. **JUnit Jupiter API:** Allows the use of JUnit 5 for testing.

## How to Start the Application

Follow the steps below to start the User Info Server application:

1. Make sure you have Java 17 (or a compatible version) installed on your machine.
2. Ensure that you have a MySQL database set up and ready to use.
3. Clone this repository to your local machine.
4. Navigate to the root directory of the project containing the `pom.xml` file.
5. Build the application using Maven:
   ```bash
   mvn clean install compile
   ```
6. After a successful build, you can run the application using Maven:
   ```bash
   mvn spring-boot:run
   ```
   Alternatively, you can also run the application using the packaged JAR file:
   ```bash
   java -jar target/user-info-server-0.0.1-SNAPSHOT.jar
   ```
7. The User Info Server application will start, and you can access it at `http://localhost:9090`.



Thank you for your interest in the User Info Server application.
Happy coding!
