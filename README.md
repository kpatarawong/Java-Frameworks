
# Inventory Management System

This project is a full-stack web application developed as part of WGU's D287 - Java Frameworks course. It allows users to manage inventory items using a web interface backed by a Spring Boot application and a relational database.

## Features

- View a list of inventory items
- Create new inventory items
- Edit existing items
- Delete items
- Form input validation with appropriate error handling
- Integration with a MySQL or H2 database using Spring Data JPA
- Dynamic user interface using Thymeleaf

## Technologies Used

- Java 17
- Spring Boot
- Spring MVC
- Spring Data JPA
- Thymeleaf
- MySQL or H2 Database
- Maven
- Git

## Getting Started

### Prerequisites

- Java JDK 17 or higher
- Maven
- MySQL (or use the embedded H2 database)
- Git

### Clone the Repository

```bash
git clone https://github.com/your-username/d287-inventory-system.git
cd d287-inventory-system
```

### Database Configuration

Update the file `src/main/resources/application.properties` with your database credentials.

For MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/inventory_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

For H2 (development only):

```properties
spring.datasource.url=jdbc:h2:mem:inventorydb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

### Build and Run the Application

```bash
mvn spring-boot:run
```

Once the application starts, navigate to `http://localhost:8080` in your browser.

## Project Structure

```
src/
├── controller/
├── model/
├── repository/
├── service/
├── templates/
│   ├── index.html
│   ├── create.html
│   └── edit.html
└── application.properties
```

## Possible Future Enhancements

- User authentication and authorization using Spring Security
- Pagination, filtering, and search capabilities
- REST API versioning for external consumption
- Deployment to cloud hosting (e.g., Render, Railway, or AWS)

## License

This project was developed for academic purposes as part of WGU's Bachelor of Science in Computer Science program. All rights reserved.
