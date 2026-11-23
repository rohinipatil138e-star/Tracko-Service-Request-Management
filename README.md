# Tracko-Service-Request-Management
Tracko is a Field Engineer Tracking System built using Java, Spring Boot, MySQL, and Thymeleaf. It helps manage engineers, customers, service requests, and engineer assignments based on technical departments. The system aims to simplify field service management and improve work coordination.

🚀 Tracko – Field Engineer Tracking System

Tracko is a web-based Field Engineer Tracking System developed using Java, Spring Boot, MySQL, and Thymeleaf. It is designed to simplify field service management by managing engineers, customers, service requests, and engineer assignments.

📌 Project Overview

Tracko helps administrators manage field engineers and customer service requests efficiently. It provides a centralized platform to organize service operations and assign suitable engineers based on their technical departments.

✨ Features

- User Login: Login interface for accessing the application.
- Dashboard: Centralized dashboard for managing service activities.
- Engineer Management: Add, view, and manage engineer details.
- Customer Management: Maintain customer information.
- Service Request Management: Create and manage customer service requests.
- Smart Engineer Assignment: Match engineers with service requests based on their technical departments.
- Request Status Management: Track Pending, Assigned, and Completed requests.
- Engineer Profiles: View individual engineer information.

🛠️ Technologies Used

Technology| Purpose
Java 21| Backend programming
Spring Boot| Backend framework
Spring MVC| Web application architecture
Spring Data JPA| Database operations
MySQL| Database
Thymeleaf| Dynamic web pages
HTML5| Web page structure
CSS3| Styling
JavaScript| Frontend functionality
Maven| Dependency management

📂 Project Structure

Tracko/
│
├── src/
│   └── main/
│       ├── java/com/tracko/
│       │   ├── controller/
│       │   ├── entity/
│       │   ├── repository/
│       │   ├── service/
│       │   └── TrackoApplication.java
│       │
│       └── resources/
│           ├── templates/
│           ├── static/
│           └── application.properties
│
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .gitignore
└── README.md

⚙️ Installation and Setup

1. Clone the Repository

git clone https://github.com/YOUR-USERNAME/Tracko-Field-Engineer-Tracking-System.git

2. Open the Project

Open the downloaded project in VS Code or IntelliJ IDEA.

3. Configure MySQL

Create a MySQL database:

CREATE DATABASE tracko_db;

Update your "application.properties" file with your MySQL database credentials.

4. Run the Application

Using Maven:

mvn spring-boot:run

Or using Maven Wrapper on Windows:

.\mvnw.cmd spring-boot:run

5. Open in Browser

http://localhost:8080

🎯 Project Objectives

- Simplify field engineer management.
- Improve customer service request handling.
- Reduce manual engineer assignment.
- Match engineers with suitable technical requirements.
- Improve service management and coordination.

🔮 Future Enhancements

- Real-time GPS-based engineer tracking.
- Role-based access control.
- Automated engineer assignment.
- Email and SMS notifications.
- Advanced reports and analytics.

👩‍💻 Developer

Rohini Patil

Project: Tracko – Field Engineer Tracking System

📄 License

This project is developed for educational and portfolio purposes.
