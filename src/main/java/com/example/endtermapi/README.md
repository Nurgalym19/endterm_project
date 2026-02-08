Endterm Project — Football Team Management REST API
A. Project Overview

This project is a Football Team Management System implemented as a Spring Boot RESTful API.
It allows managing football teams and players, including their positions and squad numbers.

The project integrates:

Design Patterns

SOLID principles

Component principles

RESTful architecture

PostgreSQL database

It is the final integration of concepts from previous assignments into a professional backend system.

---
B. REST API Documentation

Player Endpoints:

Method    ------  Endpoint-----Description

Post   ------/players------Create a new player

Get------/players-----Get all players

Get----/players/{id}----Get players by ID

PUT-----/players/{id}----Update player

DELETE----/players/{id}----Delete player

---
Team Endpoints

Method-----EndPoint-----Description

Post----/teams----Create Team

Get----/teams----Get all teams

Get----/teams/{id}---Get teams by ID

Delete---/teams/{id}----Delete team

---


 Sample JSON — Create Player

     {
     "name": "Lamine Yamal",

     "age": 18,

      "position": "Right Winger",

     "number": 27,

    "team": {

     "id": 1
     }

      }

---
 Sample JSON Response

    {

    "id": 1,

    "name": "Lamine Yamal",

     "age": 18,

    "position": "Right Winger",

    "number": 27,

     "team": {

     "id": 1,

    "name": "Barcelona"

     }

    }


All endpoints were tested using Postman

Screenshots are included in /docs/screenshots

---

C. Design Patterns Used


1-Singleton Pattern — AppConfig

Ensures a single shared configuration instance

Used for application-level configuration

2️-Builder Pattern — PlayerBuilder

Used to construct Player objects step by step

Improves readability and handles multiple parameters

Supports fluent method chaining

3️- Factory Pattern — PlayerFactory

Encapsulates Player object creation

Separates creation logic from business logic

---

D. Component Principles

The project structure follows component principles:

REP (Reuse/Release Equivalence Principle)
Reusable components like services, repositories, and patterns are grouped logically.

CCP (Common Closure Principle)
Classes that change together (e.g. Player entity, service, repository) are grouped together.

CRP (Common Reuse Principle)
Modules depend only on what they actually use.

---

E.  . SOLID & OOP Summary

The project applies SOLID principles in a practical manner:

1)Single Responsibility Principle is achieved by separating controllers, services, and repositories.

2)Open/Closed Principle is partially supported, allowing extension through new services and endpoints.

3)Liskov Substitution Principle is implemented using service interfaces and their implementations.

4)Interface Segregation Principle is followed by keeping service interfaces small and focused.

5)Dependency Inversion Principle is applied through constructor-based dependency injection.

Advanced OOP features:

Encapsulation

Inheritance

Polymorphism

Abstraction

---

F. Database Schema

Tables:

Team;

1. id

2. name

---

Player;

1. id
2. name
3. age
4. position
5. number
6. team_id(FK)

RelationShip:

One Team -> Many Players

Implemented with @OneToMany and @ManyToOne

---

G. System Architecture Diagram

The system follows a layered architecture:

    Controller -> Service -> Repository -> Database

UML diagrams are included in:

/docs/screenshots

---

H. Instructions to Run the Application

1️. Requirements

Java 17+

PostgreSQL

Maven

2️. Database Configuration

Update application.properties:

     spring.datasource.url=jdbc:postgresql://localhost:5432/endterm_db
     spring.datasource.username=postgres
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update

3️. Run the Project

mvn spring-boot:run

4️. Test API

     http://localhost:8080/players

I. Reflection

This project helped consolidate knowledge of:

Spring Boot REST APIs

Design Patterns in real applications

SOLID principles

Database integration

Professional backend architecture

It demonstrates how multiple software engineering concepts can be integrated into a complete, working system

---
What I Learned

During this project, I learned how to design and implement a complete RESTful backend application using Spring Boot and PostgreSQL.

I gained practical experience in building a layered architecture, separating responsibilities between controllers, services, and repositories. This helped me better understand how large backend systems are structured and maintained.

I also learned how to apply SOLID principles in practice, especially through interface-based services and dependency injection. Although not every principle was applied perfectly, the project showed how SOLID improves code readability and flexibility.

Another important learning outcome was the use of design patterns such as Builder, Factory, and Singleton, and understanding when and why they should be used in real-world applications.

Finally, I improved my skills in database design, entity relationships, REST API testing with Postman, and error handling through meaningful HTTP responses.


