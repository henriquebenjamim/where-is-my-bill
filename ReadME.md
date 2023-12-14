# Where is my bill?

This project is a menu management system developed using Java 17, Spring Boot 3, RabbitMQ, JPA Hibernate, Postgres, JUnit 5, and Docker.

## Overview

The Menu Management System is designed to efficiently manage menus, categories, orders, and associated data in a restaurant setting.

### Technologies Used

- **Java 17**: The latest version of Java programming language, offering improved performance and features.
- **Spring Boot 3**: Facilitates rapid development and simplifies the setup of Spring-based applications.
- **RabbitMQ**: Provides a robust message broker for handling communication between components.
- **JPA Hibernate**: Offers an ORM framework for mapping objects to databases and simplifying data persistence.
- **Postgres**: The chosen relational database for storing menu, category, and order-related information.
- **JUnit 5**: Enables robust and comprehensive testing capabilities for the application.
- **Docker**: Used for containerization, ensuring consistent deployment across different environments.

### Installation and Setup

1. **Java 17**: Ensure Java 17 is installed on your machine.
2. **Spring Boot**: Utilize Spring Boot 3 for running the application.
3. **RabbitMQ**: Set up RabbitMQ as the message broker.
4. **Postgres**: Install and configure Postgres for data storage.
5. **JUnit 5**: Run JUnit 5 tests to ensure proper functionality.
6. **Docker**: Containerize the application for deployment in Docker containers.

### Usage

1. **API Endpoints**: Utilize the defined API endpoints to manage menus, categories, orders, and associated data.
2. **Testing**: Leverage the JUnit 5 test suite to verify the correctness of implemented functionalities.
3. **Containerization**: Deploy the application using Docker containers for easy scaling and management.

### Folder Structure

- **src/main**: Contains the main application code.
- **src/test**: Houses the test suites and test cases.

## Running the Application

To run the Menu Management System:

1. Set up the required dependencies (Java 17, Spring Boot 3, RabbitMQ, Postgres).
2. Clone the repository: `git clone https://github.com/yourusername/menumgmt.git`.
3. Navigate to the project directory.
4. Run `./mvnw spring-boot:run` to start the Spring Boot application.
5. Access the API endpoints at `http://localhost:8080`.

## Docker Deployment

To deploy the application using Docker:

1. Build the Docker image: `docker build -t menumgmt:latest .`
2. Run the Docker container: `docker run -p 8080:8080 menumgmt:latest`

## Contributing

Contributions are welcome! Please follow the guidelines outlined in CONTRIBUTING.md.

## License

This project is licensed under the [Your License Name] License - see the LICENSE.md file for details.
