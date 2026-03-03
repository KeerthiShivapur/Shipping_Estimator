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
GET /api/v1/warehouse/nearest


Returns the nearest warehouse based on seller location.

---

### 2️⃣ Get Shipping Charge from Warehouse
GET /api/v1/shipping-charge


Returns shipping charge based on:
- Warehouse ID
- Customer ID
- Delivery Speed

---

### 3️⃣ Calculate Complete Shipping Charge
POST /api/v1/shipping-charge/calculate


### Sample Request

```json
{
  "sellerId": 123,
  "customerId": 456,
  "deliverySpeed": "EXPRESS"
}
Sample Response
Json

{
  "shippingCharge": 6976.13,
  "distanceInKm": 290.17,
  "deliveryType": "EXPRESS",
  "transportMode": "TRUCK",
  "nearestWarehouse": {
    "warehouseId": 1,
    "name": "BLR_Warehouse",
    "warehouseLocation": {
      "lat": 12.9716,
      "lon": 77.5946
    }
  }
}
```
### --- 🚚 Transport Mode Logic
Transport mode is dynamically selected based on distance:
Distance Range
Mode
Rate Logic
0–100 km
MINI_VAN
Higher rate
100–500 km
TRUCK
Medium rate
500+ km
AEROPLANE
Lower rate
⚙️ Delivery Pricing Strategy
Implemented using Strategy Pattern:
Standard Delivery
Express Delivery (adds additional charge)
This design allows easy extension for future delivery types without modifying existing logic.

✨ Key Highlights

###### ✔ Clean layered architecture
###### ✔ Strategy Pattern for extensible delivery logic
###### ✔ Haversine formula for geographic distance calculation
###### ✔ Dynamic transport mode selection
###### ✔ Structured JSON error handling
###### ✔ Production-ready response formatting (rounded values)
###### ✔ Easily extensible and maintainable design

▶️ How to Run
Clone the repository
Navigate to project root (where pom.xml exists)
Run:


##### mvn clean install
##### mvn spring-boot:run
##### Application starts at:

##### http://localhost:8080
#### 🧪 Testing
#### APIs tested using Postman.

#### POST http://localhost:8080/api/v1/shipping-charge/calculate

