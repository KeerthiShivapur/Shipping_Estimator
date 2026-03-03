# 🚀 Shipping Charge Estimator (B2B E-Commerce)

## 📌 Problem Statement

Build a REST API-based application to calculate shipping charges in a B2B e-commerce marketplace based on:

- Seller location
- Customer location
- Nearest warehouse
- Distance-based transport mode
- Delivery speed (Standard / Express)

---

## 🏗️ Architecture

The project follows a clean layered architecture:

- *Controller Layer* – Handles REST APIs
- *Service Layer* – Business logic implementation
- *Strategy Pattern* – Extensible delivery pricing logic
- *Model Layer* – Data models
- *Exception Handling* – Structured API error responses

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot
- Maven
- H2 (In-Memory Database)
- Postman (API Testing)

---

## 📡 Implemented APIs

### 1️⃣ Get Nearest Warehouse
