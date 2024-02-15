# Course Microservice : Spring Boot & Spring Cloud

## Requirements

- Java 17
- Spring Boot 3.2.2
- Http Client

## Technologies

- Spring Data Jpa
- Spring validation
- JPA Test
- Unit Test
- Spring cloud config service
- Spring cloud Eureka server
- Spring cloud Feign
- Spring cloud Hystrix
- Spring cloud gateway
- Spring cloud actuator
- Spring cloud admin
- Spring cloud Resilience4j

## Services


### Config Service
- Default: http://localhost:8090/customer-service/default
- Dev: http://localhost:8090/customer-service/dev
- Prod: http://localhost:8090/customer-service/prod
- Test: http://localhost:8090/customer-service/test

### Discovery  Service (Eureka)

http://localhost:8099/


### Microservice Product
http://localhost:8091/products

### Microservice Customer
http://localhost:8091/customers


### Microservice Shopping
http://localhost:8093/invoices

### Gateway Service

- Customer: http://localhost:8080/customers
- Products: http://localhost:8080/products
- Invoices: http://localhost:8080/invoices