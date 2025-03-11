# WebApp - Employee Management

## Description
WebApp is a web application developed with **Spring Boot** for managing employees within a company.  
It is designed for the **HR department**, allowing them to:
- Add an employee 👤  
- Edit an employee ✏️  
- Delete an employee ❌  

The application connects to a **REST API** to retrieve and manipulate data stored in an **H2 database**.

##  Architecture
The application is structured into multiple layers:
- **Controller**: Handles HTTP requests and responses.  
- **Service**: Contains the business logic.  
- **Repository**: Interfaces with the H2 database using **Spring Data JPA**.  
- **Model**: Represents the database entities.  

## Installation & Execution

### Prerequisites
- **JDK 17+**  
- **Maven**  
- **Spring Boot**  
