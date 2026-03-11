# Restaurant Order Service

Order microservice for the Restaurant Digital Ordering System.

## Responsibilities

- Create customer orders
- Validate restaurant and menu
- Manage order lifecycle
- Integrate with kitchen and payment services

## Tech Stack

Spring Boot 3.x  
Spring Cloud  
OpenFeign  
Resilience4j  
MySQL  
MapStruct  
Swagger OpenAPI  
Lombok  

## Architecture

Client
↓
API Gateway
↓
Order Service
↓
Restaurant Service
↓
Menu Service
↓
MySQL
