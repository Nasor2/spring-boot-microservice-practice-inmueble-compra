# Spring Boot Microservices Architecture

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-6DB33F.svg?style=flat&logo=spring&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-20.x-2496ED.svg?style=flat&logo=docker&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.x-C71A36.svg?style=flat&logo=apache-maven&logoColor=white)

A robust, scalable, and modern **microservices-based application** built with **Spring Boot**, designed with a focus on modularity, security, and efficient inter-service communication. This project showcases a comprehensive backend system with an **API Gateway**, multiple **microservices**, and **Eureka** for service discovery.

> [!NOTE]
> This project is designed as a learning-focused implementation, prioritizing development environment emulation over production concerns like environment variables or advanced deployment configurations.

---

## 📋 Project Overview

This project implements a microservices architecture to manage **real estate properties** and **user purchases**. It leverages **Spring Boot** for backend services, **Feign** for inter-service communication, and **Eureka** for service discovery. The system includes secure **JWT-based authentication** and **role-based authorization** for robust access control and data integrity.

### ✨ Key Features

- **API Gateway**: Central entry point for client requests, handling authentication, authorization, and routing.
- **Microservices**:
  - **Property Service**: Manages real estate properties with CRUD operations, backed by **PostgreSQL**.
  - **Purchase Service**: Handles user purchase records, using an **H2** in-memory database.
  - **User Management**: Supports user registration, login, and role-based access control with **MySQL**.
- **Service Discovery**: **Eureka Server** enables dynamic service registration and discovery.
- **Security**: **JWT-based authentication** and **role-based authorization** for secure access.

> [!IMPORTANT]
> The application uses hardcoded configurations (e.g., database URLs, ports) to simplify the learning process, intentionally avoiding environment variables to focus on understanding core microservices concepts in a development context.

---

## 🏛️ Architecture

The project follows a **microservices architecture** with the following components:

| Component            | Description                                                                 |
|----------------------|-----------------------------------------------------------------------------|
| **API Gateway**      | Routes requests using **Spring Cloud Gateway** and **Feign** clients.        |
| **Microservices**    | Independent services (Property, Purchase, User Management) with dedicated databases. |
| **Eureka Server**    | Centralizes service registration, replacing static URLs with service names.  |
| **Database Layer**   | **PostgreSQL** (Property Service), **H2** (Purchase Service), **MySQL** (API Gateway/User Management). |

> [!TIP]
> Use **Postman** to test API endpoints and verify inter-service communication, leveraging **Eureka**’s service discovery for dynamic routing.

---

## 🛠️ Technologies & Tools

| Category         | Tools/Frameworks                                      |
|------------------|-------------------------------------------------------|
| **Backend**      | **Spring Boot**: Core framework for microservices and REST APIs.<br>**Spring Cloud**: **Feign** for REST clients, **Eureka** for service discovery.<br>**Spring Security**: **JWT-based** authentication and authorization.<br>**Lombok**: Reduces boilerplate with annotations like `@Getter`, `@Setter`, `@Data`. |
| **Databases**    | **PostgreSQL**: Persistent storage for Property Service.<br>**MySQL**: Storage for API Gateway and User Management.<br>**H2**: In-memory database for Purchase Service. |
| **DevOps**       | **Docker**: Containers for **MySQL** and **PostgreSQL**.<br>**Maven**: Dependency management and build tool. |
| **Testing**      | **Postman**: API testing tool for verifying endpoints. |

> [!CAUTION]
> The use of **H2** in-memory database for the Purchase Service is for demonstration purposes only. In a production environment, consider a persistent database like **PostgreSQL** or **MySQL** for data durability.

---

## 🔧 Design Patterns

- **Dependency Injection**: **Spring**’s IoC container ensures loose coupling.
- **Dependency Inversion Principle**: Interfaces decouple high-level modules from implementations.
- **RESTful Design**: Uses `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`, and `@PatchMapping` for REST APIs.
- **Single Responsibility Principle**: Each microservice handles a specific domain.
- **CQRS**: Separates read and write operations for clarity.
- **Facade Pattern**: **API Gateway** abstracts microservice complexity.

---

## ⚙️ Key Practices

- **REST Controllers**: Clear endpoint mappings with `@RestController` and `@RequestMapping`.
- **Request/Response Handling**: Flexible data processing with `@RequestBody`, `@PathVariable`, and `@RequestParam`.
- **Security Configuration**: **JWT** filters for access control.
- **Service Discovery**: **Eureka** eliminates hardcoded URLs for dynamic environments.
- **Clean Code**: **Lombok** minimizes boilerplate for readable code.
- **Modular Design**: Independently deployable microservices with dedicated databases.

> [!WARNING]
> Hardcoded tokens and configurations are used for educational purposes. In production, implement secure secret management (e.g., **Spring Vault**) and environment variables to protect sensitive data.

---

## 📂 Project Structure

- **API Gateway**: Manages routing, authentication, and authorization.
- **Property Microservice**: Handles property data CRUD operations.
- **Purchase Microservice**: Manages purchase records.
- **Eureka Server**: Registers microservices dynamically.

---

## 🌟 Highlights

- **Scalability**: Microservices enable independent scaling.
- **Maintainability**: Loose coupling and **dependency injection** simplify updates.
- **Security**: **JWT** and **role-based access control** (e.g., admin-only operations).
- **Dynamic Service Discovery**: **Eureka** simplifies communication in dynamic environments.

---

## 📚 Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Cloud Documentation](https://spring.io/projects/spring-cloud)
- [Eureka Service Discovery](https://github.com/Netflix/eureka)
- [Postman API Testing](https://www.postman.com/)

---

This project serves as a showcase of modern backend development, blending **Spring Boot**’s capabilities with a **microservices architecture** for a robust and scalable solution.
