# 🚗 RideHub

> A case study of a ride-hailing platform inspired by Uber, focused on back-end architecture, business rules, and software development best practices.

![Status](https://img.shields.io/badge/status-in%20development-yellow)
![Java](https://img.shields.io/badge/Java-17%2B-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![License](https://img.shields.io/badge/license-MIT-blue)


---

## 📑 Table of Contents

- [About the Project](#-about-the-project)
- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Architecture](#-architecture)
- [Prerequisites](#-prerequisites)
- [Getting Started](#-getting-started)
- [API Endpoints](#-api-endpoints)
- [Testing](#-testing)
- [Project Structure](#-project-structure)
- [Roadmap](#-roadmap)
- [Author](#-author)
- [License](#-license)

---

## 📖 About the Project

**RideHub** is a case study project that simulates the core of a ride-hailing platform like Uber. Its goal is to practice and demonstrate, end to end, the development of a robust back-end API: domain modeling, business rules, data persistence, and layered code organization.

**The problem it explores:** connecting passengers with drivers, managing the lifecycle of a ride, and calculating fares consistently.

> ⚠️ This is an educational project and is not affiliated with Uber or any other company.

---

## ✨ Features



- [ ] User registration and authentication (passengers and drivers)
- [ ] Vehicle registration
- [ ] Ride requests (origin and destination)
- [ ] Driver assignment to rides
- [ ] Ride status management (requested, accepted, in progress, completed, canceled)
- [ ] Estimated and final fare calculation
- [ ] Ride history
- [ ] Driver and passenger ratings

---

## 🛠 Tech Stack


| Layer | Technology |
| --- | --- |
| Language | Java |
| Framework | Spring Boot |
| API | REST |
| Persistence | Spring Data JPA / Hibernate |
| Database | PostgreSQL |
| Build | Maven |
| Testing | JUnit 5, Mockito |

---

## 🏗 Architecture

The project follows a layered architecture, separating concerns to make maintenance and testing easier:

```
Controller  →  Service  →  Repository  →  Database
    ↓             ↓
   DTOs      Business rules
```

- **Controller:** exposes the REST endpoints and validates input.
- **Service:** holds the business rules.
- **Repository:** data access via JPA.
- **DTOs / Entities:** decouple the API contract from the domain model.



---

## ✅ Prerequisites

- [Java JDK 17+](https://adoptium.net/)
- [Maven 3.8+](https://maven.apache.org/)
- [PostgreSQL 14+](https://www.postgresql.org/)
- Git

---

## 🚀 Getting Started

**1. Clone the repository**

```bash
git clone https://github.com/josemariadev12/RideHub.git
cd RideHub/ridehub/app
```

**2. Create the database**

```sql
CREATE DATABASE ridehub;
```

**3. Configure environment variables**

Edit `src/main/resources/application.properties` (or use environment variables):

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ridehub
spring.datasource.username=YOUR_USER
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
```

**4. Run the application**

```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`.


---

## 🔌 API Endpoints


| Method | Endpoint | Description |
| --- | --- | --- |
| `POST` | `/users` | Register a user |
| `POST` | `/drivers` | Register a driver |
| `POST` | `/rides` | Request a ride |
| `GET` | `/rides/{id}` | Get ride details |
| `PATCH` | `/rides/{id}/status` | Update ride status |
| `GET` | `/users/{id}/rides` | List ride history |

**Sample request**

```http
POST /rides
Content-Type: application/json

{
  "passengerId": 1,
  "origin": "Av. Paulista, 1000",
  "destination": "Congonhas Airport"
}
```

---

## 🧪 Testing

```bash
mvn test
```

---

## 📂 Project Structure

<!-- ADJUST: paste the real structure here (command: tree -L 4 src). -->

```
ridehub/
└── app/
    ├── src/
    │   ├── main/
    │   │   ├── java/        # Source code
    │   │   └── resources/   # Configuration
    │   └── test/            # Tests
    └── pom.xml
```

---

## 🗺 Roadmap

- [ ] Business Rules
- [ ] JWT authentication and authorization
- [ ] API documentation with Swagger / OpenAPI
- [ ] Distance and estimated time calculation
- [ ] Dockerization (Dockerfile + docker-compose)
- [ ] CI pipeline with GitHub Actions
- [ ] Real-time notifications (WebSocket)

---

## 👨‍💻 Author

**José Maria**

- GitHub: [@josemariadev12](https://github.com/josemariadev12) www.linkedin.com/in/josé-maria-8b507b27b

- Linkedin: [@José Maria](www.linkedin.com/in/josé-maria-8b507b27b) 

---

## 📄 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.