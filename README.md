# Requirements

Before running the project, make sure you have installed:

- Java 17
- Maven
- MySQL Server
- IntelliJ IDEA (recommended)

---

# Database Configuration

Create a MySQL database.

Example:

```sql
CREATE DATABASE shopping_cart;
```

Then update the database configuration in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/shopping_cart
spring.datasource.username=root
spring.datasource.password=your_password
```

---

# Using Another Database

If you want to use another database engine instead of MySQL:

1. Replace the MySQL dependency in `pom.xml`
2. Update the JDBC URL
3. Update the Hibernate dialect if necessary
4. Configure the correct username and password

Example databases:
- PostgreSQL
- SQL Server
- H2

---

# JWT Configuration

The project uses JWT authentication.

You can configure the secret key in:

```properties
jwt.secret=your_secret_key
```

inside:

```text
application.properties
```

---

# Running the Application

Clone the repository:

```bash
git clone <repository_url>
```

Install dependencies:

```bash
mvn clean install
```

Run the application:

```bash
mvn spring-boot:run
```

The application will run on:

```text
http://localhost:8080
```

---

# Swagger Documentation

Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

---

# Authentication

This project uses JWT Authentication with Spring Security.

Before testing protected endpoints, you must first:

## 1. Register a new user

```http
POST /auth/register
```

---

## 2. Login with your credentials

```http
POST /auth/login
```

Example:

```json
{
  "email": "jose123@gmail.com",
  "password": "12345"
}
```

After login, the API will return a JWT token.

Example response:

```text
eyJhbGciOiJIUzI1NiJ9...
```

---

## 3. Use the JWT token in Postman

Protected endpoints require:

```text
Authorization: Bearer <your_token>
```

Example:

```text
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
```

---

# Important Swagger Note

Swagger was successfully integrated into the project, but JWT authentication handling presented issues with some protected endpoints during testing.

Because of this:

- Swagger is recommended only for:
  - Register
  - Login

- Postman is recommended for testing protected endpoints:
  - Clients
  - Products
  - Orders
  - Order Details
  - Payments

This ensures proper JWT authentication behavior.

---

# Language Note

Some internal legacy modules and old class names remain partially in Spanish due to project migration and time constraints during development.

However:

- Commits were written in English
- New modules were implemented in English
- Documentation follows English conventions
- Modern backend architecture practices were applied throughout the project
