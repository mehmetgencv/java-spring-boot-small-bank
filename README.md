
# Bank Application

This project is being developed as part of the N11 TalentHub Bootcamp. New features are added every week to enhance the functionality.

## Technologies

- Spring Boot 3.2.2
- Java 21
- Maven project
- PostgreSQL

## Features

### Week 1

- Customer entity created.
- Customer services and APIs implemented.
- Database connectivity established.
- Swagger integration added.

### Week 2

- Account entity created.
- Account services and APIs implemented.
- Error handling structure added.

## How to Run

1. Start PostgreSQL database.
2. Download or clone the project files.
3. Navigate to the project directory.
4. Run `mvn spring-boot:run` command to start the application.

## Example Requests

### Create a New Customer
```http
POST /api/v1/customers
Content-Type: application/json

{
  "name": "string",
  "surname": "string",
  "birthDate": "2024-02-20",
  "username": "string",
  "identityNo": "string",
  "password": "string",
  "phoneNumber": "string",
  "email": "string"
}
```

### Get All Customers
```http
GET /api/v1/customers
```

### Update Customer Information
```http
PATCH /api/v1/customers/{customerId}
Content-Type: application/json

{
  "id": 0,
  "name": "string",
  "surname": "string",
  "birthDate": "2024-02-20",
  "phoneNumber": "string",
  "email": "string"
}
```

### Delete a Customer
```http
DELETE /api/v1/customers/{customerId}
```

<a href="https://www.n11.com/">
  <img src="public/images/n11_logo.png" alt="N11 Logo">
</a>

<a href="https://www.patika.dev/">
  <img src="public/images/patika_logo.png" alt="Patika Logo">
</a>