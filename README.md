# 🚀 Spring Boot Microservices - Order Management System

A production-style **Spring Boot Microservices** project demonstrating service discovery, centralized configuration, API Gateway, inter-service communication, fault tolerance, and centralized exception handling.

## 📌 Features

- Microservices Architecture
- Spring Cloud Config Server
- Eureka Service Discovery
- Spring Cloud Gateway
- OpenFeign for Inter-Service Communication
- Resilience4j Circuit Breaker
- Global Exception Handling
- Centralized Configuration using Git Repository
- RESTful APIs
- Spring Data JPA
- MySQL Database

---

# 🏗️ Architecture

```
                Client
                   │
                   ▼
          API Gateway (Spring Cloud Gateway)
                   │
     ┌─────────────┴─────────────┐
     ▼                           ▼
Customer Service           Order Service
      │                           │
      └──────────Feign────────────┘
                   │
             Eureka Discovery
                   │
             Config Server
                   │
            Git Configuration Repo
```

---

# 📂 Project Structure

```
microservices-all-features
│
├── config-service
├── discovery-service
├── gateway-service
├── customer-service
└── order-service
```

---

# 🛠️ Tech Stack

### Backend

- Java 21
- Spring Boot 3
- Spring Data JPA
- Spring Cloud
- Spring Cloud Gateway
- Spring Cloud Config
- Spring Cloud Netflix Eureka
- OpenFeign
- Resilience4j
- Maven

### Database

- MySQL

### Tools

- Postman
- Git
- GitHub
- IntelliJ IDEA

---

# ⚙️ Microservices

## 1. Config Server

Provides centralized configuration for all microservices using a Git repository.

---

## 2. Discovery Service

Acts as the Eureka Server where all services register themselves.

---

## 3. API Gateway

Provides a single entry point for all client requests and routes traffic to the appropriate microservice.

---

## 4. Customer Service

Responsible for:

- Customer CRUD Operations
- Database Persistence
- Exception Handling

---

## 5. Order Service

Responsible for:

- Order CRUD Operations
- Fetching Customer Details using OpenFeign
- Circuit Breaker with Fallback Responses
- Exception Handling

---

# 🔄 Service Communication

```
Client
   │
   ▼
Gateway
   │
   ▼
Order Service
   │
Feign Client
   │
   ▼
Customer Service
```

---

# 🛡️ Fault Tolerance

Implemented using **Resilience4j Circuit Breaker**.

When the Customer Service becomes unavailable:

- Circuit Breaker opens
- Fallback method executes
- User receives a meaningful error response instead of application failure

---

# ⚠️ Exception Handling

Implemented centralized exception handling using:

- `@RestControllerAdvice`
- Custom Exceptions
- Custom Error Response DTO
- HTTP Status Codes

Example response:

```json
{
    "message": "Customer Not Found",
    "status": 404,
    "timestamp": "2026-07-09T18:20:10"
}
```

---

# 🗄️ Database

Each microservice maintains its own independent database.

- Customer Database
- Order Database

This follows the **Database per Service** pattern.

---

# 🚀 Running the Project

Start the services in the following order:

1. Config Server
2. Discovery Service
3. API Gateway
4. Customer Service
5. Order Service

---

# 🔗 API Endpoints

## Customer Service

| Method | Endpoint |
|---------|----------|
| GET | `/customer/{id}` |
| POST | `/customer` |
| PUT | `/customer/{id}` |
| DELETE | `/customer/{id}` |

---

## Order Service

| Method | Endpoint |
|---------|----------|
| GET | `/order/{id}` |
| POST | `/order/placeorder` |
| PUT | `/order/{id}` |
| DELETE | `/order/{id}` |

---

# 📸 Screenshots

Add screenshots here.

Example:

- Eureka Dashboard
- Gateway Routing
- Successful Order Request
- Circuit Breaker Response
- Exception Response
- MySQL Tables

---

# 📁 Config Repository

Paste your Config Server Git Repository link below:

> **Config Repository:**  
> `______________________________________________`

or

```
https://github.com/your-username/your-config-repository
```

---

# 🎯 Future Improvements

- Docker
- Docker Compose
- Kubernetes
- Spring Security with JWT
- Distributed Tracing
- Zipkin
- Prometheus & Grafana
- Kafka/RabbitMQ
- CI/CD Pipeline
- Unit & Integration Testing

---

# 👨‍💻 Author

**Vivek**

GitHub:
https://github.com/Vivek-pen

---

# ⭐ If you found this project useful, don't forget to star the repository!
