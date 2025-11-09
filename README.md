# 🧾 Spring Boot JWT Security Demo — Trade API

A minimal demo project built with **Spring Boot 3.5.7** and **Java 21**, showcasing:
- User registration & login with **JWT authentication**
- Role-based access control (`ROLE_USER`, `ROLE_ADMIN`)
- Secured **Trade API** endpoints

---

## 🚀 Overview

This project demonstrates:
- How users and admins can register and login
- How JWT tokens are issued and used for authorization
- How role-based access is enforced for REST APIs

---

## 🧩 Base URL

http://localhost:8080


---

## 🔐 Authentication APIs

### 1️⃣ Register User

**POST** `/api/auth/register`

Registers a new user. Default role: `ROLE_USER`

**Request Body**
```json
{
  "username": "rajesh",
  "password": "secret123",
  "role": "USER"
}
User registered successfully with role: ROLE_USER

2. Register Admin

POST /api/auth/register

Registers a new admin. Default role: ROLE_ADMIN

Request Body

{
  "username": "adminuser",
  "password": "secret123",
  "role": "ADMIN"
}
User registered successfully with role: ROLE_ADMIN
2. Create a Trade

POST /api/trades

Access: ROLE_ADMIN only

Headers

Authorization: Bearer <ADMIN_TOKEN>
Content-Type: application/json

{
  "symbol": "TSLA",
  "price": 250.50,
  "quantity": 10
}
3. Delete a Trade

DELETE /api/trades/{id}

Access: ROLE_ADMIN only

Headers

Authorization: Bearer <ADMIN_TOKEN>
