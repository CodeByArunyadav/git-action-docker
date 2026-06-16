# Employee Management API - Swagger Setup Guide

## Overview
This Spring Boot application implements a complete REST API for Employee Management with integrated Swagger/OpenAPI documentation.

## Prerequisites
- Java 17+
- Maven 3.6+
- MySQL 8.0.40+ (running on localhost:3306)
- Database: `demo_db` created in MySQL

## Database Setup

Create the database and user:
```sql
CREATE DATABASE demo_db;
CREATE USER 'root'@'localhost' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON demo_db.* TO 'root'@'localhost';
FLUSH PRIVILEGES;
```

## Building the Project

```cmd
cd c:\Users\hp\git\git-action-docker\demo-git_action-docker
mvnw.cmd clean install
```

## Running the Application

```cmd
mvnw.cmd spring-boot:run
```

Or if Maven is installed globally:
```cmd
mvn spring-boot:run
```

The application will start on **port 8085**.

## Accessing Swagger UI

Once the application is running, access the Swagger UI at:

### **Swagger UI (Interactive):**
```
http://localhost:8085/swagger-ui.html
```

### **OpenAPI JSON:**
```
http://localhost:8085/api-docs
```

### **OpenAPI YAML:**
```
http://localhost:8085/api-docs.yaml
```

## API Endpoints

All endpoints are fully documented in Swagger UI. Below is a quick reference:

### 1. Welcome Endpoint
- **Method:** GET
- **URL:** `http://localhost:8085/`
- **Response:** Welcome message

### 2. Get Sample Employee
- **Method:** GET
- **URL:** `http://localhost:8085/employee`
- **Response:** Sample employee with hardcoded data

### 3. Create Employee
- **Method:** POST
- **URL:** `http://localhost:8085/employee`
- **Body (JSON):**
```json
{
  "name": "Jane Doe",
  "email": "jane.doe@example.com",
  "department": "HR"
}
```

### 4. Get Employee by ID
- **Method:** GET
- **URL:** `http://localhost:8085/employee/{id}`
- **Example:** `http://localhost:8085/employee/1`

### 5. Get All Employees
- **Method:** GET
- **URL:** `http://localhost:8085/employees`

### 6. Delete Employee
- **Method:** DELETE
- **URL:** `http://localhost:8085/employee/{id}`
- **Example:** `http://localhost:8085/employee/1`

## Testing with cURL

```cmd
# Get all employees
curl http://localhost:8085/employees

# Get employee by ID
curl http://localhost:8085/employee/1

# Create employee
curl -X POST http://localhost:8085/employee ^
  -H "Content-Type: application/json" ^
  -d "{\"name\":\"John Smith\",\"email\":\"john.smith@example.com\",\"department\":\"IT\"}"

# Delete employee
curl -X DELETE http://localhost:8085/employee/1
```

## Project Structure

```
demo-git_action-docker/
├── src/main/java/com/codebyarunyadav/git_action_docker/
│   ├── DemoGitActionDockerApplication.java     (Main Spring Boot app)
│   ├── Employee.java                            (JPA Entity)
│   └── controller/
│       ├── DemoController.java                  (REST endpoints)
│       ├── EmployeeService.java                 (Business logic)
│       ├── EmployeeRepository.java              (JPA repository)
│       └── SwaggerConfig.java                   (Swagger/OpenAPI config)
├── src/main/resources/
│   └── application.properties                   (Configuration)
└── pom.xml                                      (Maven dependencies)
```

## Dependencies

Key dependencies added:
- `spring-boot-starter-web` - Web MVC support
- `spring-boot-starter-data-jpa` - JPA/Hibernate support
- `mysql-connector-java` - MySQL JDBC driver
- `springdoc-openapi-starter-webmvc-ui` - Swagger UI

## Troubleshooting

### 404 Error on Swagger UI
**Issue:** Cannot access `/swagger-ui.html`

**Solutions:**
1. Ensure application started successfully (check console for errors)
2. Verify MySQL database is running and accessible
3. Check that port 8085 is not in use
4. Verify dependencies are correctly downloaded (run `mvnw.cmd clean install`)

### Application fails to start
**Check:**
1. MySQL running on localhost:3306
2. Database `demo_db` exists
3. User `root` with password `admin` has correct privileges
4. Java 17+ is installed

### Entity mapping error
If you see: "Entity Employee has no identifier"
- The Employee class already has `@Id` annotation on the id field
- Ensure `jakarta.persistence.Id` is imported (not `javax.persistence.Id`)

## Configuration Files

### application.properties
Key configuration:
- `server.port=8085` - Server port
- `spring.datasource.url` - MySQL connection URL
- `spring.jpa.hibernate.ddl-auto=update` - Auto-create/update tables
- `springdoc.swagger-ui.path=/swagger-ui.html` - Swagger UI path

## Next Steps

1. Start the application
2. Visit `http://localhost:8085/swagger-ui.html`
3. Test endpoints directly from Swagger UI
4. Use "Try it out" feature to make API calls
5. Check responses and response codes

## Support

For issues related to:
- **Swagger/OpenAPI:** Visit https://springdoc.org/
- **Spring Boot:** Visit https://spring.io/
- **MySQL:** Visit https://dev.mysql.com/

---

**API Base URL:** http://localhost:8085
**Swagger UI:** http://localhost:8085/swagger-ui.html
**Application Name:** Employee Management API
**Version:** 1.0.0
