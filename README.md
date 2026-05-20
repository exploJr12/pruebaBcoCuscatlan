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
