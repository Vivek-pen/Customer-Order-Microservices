# Spring Boot Microservices - Order Management System

This project uses a **Spring Cloud Config Server**. Before running the application, clone the configuration repository and update the `spring.cloud.config.server.git.uri` (or the Config Server configuration) accordingly.

**Configuration Repository:**

```
https://github.com/Vivek-pen/config-repo
```

---

## Tech Stack

- Java 21
- Spring Boot 3
- Spring Cloud
- Spring Cloud Gateway
- Eureka Server
- Config Server
- OpenFeign
- Resilience4j
- Spring Data JPA
- MySQL

---

## Project Structure

```
microservices-all-features
├── config-service
├── discovery-service
├── gateway-service
├── customer-service
└── order-service
```

---

## Features

- Microservices architecture
- Centralized configuration with Config Server
- Service discovery using Eureka
- API Gateway routing
- OpenFeign for inter-service communication
- Circuit Breaker using Resilience4j
- Global exception handling

---

## Running the Project

Start the services in the following order:

1. Config Service
2. Discovery Service
3. Gateway Service
4. Customer Service
5. Order Service

---

## Author

**Vivek**

GitHub: https://github.com/Vivek-pen
