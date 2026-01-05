# Job Finder Application

A role-based Job Portal built using Spring Boot, Spring Security, Thymeleaf, and MySQL.

---

## 🚀 Features

### 👤 Job Seeker
- Login & Dashboard
- View available jobs
- Apply for jobs
- View applied jobs and status

### 🧑‍💼 Employer
- Login & Dashboard
- Post new jobs
- View posted jobs
- View applicants per job

---

## 🛠️ Tech Stack
- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Thymeleaf
- MySQL
- Maven

---

## 🔐 Security
- Role-based authentication (JOB_SEEKER, EMPLOYER)
- Protected routes using Spring Security

---

## 🗄️ Database
- MySQL
- Tables:
    - jobs
    - job_applications
    - users

---

## ▶️ How to Run
1. Clone the repository
2. Configure MySQL in `application.properties`
3. Run the project using:
   ```bash
   mvn spring-boot:run
