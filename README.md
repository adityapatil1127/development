#  API Governance System

##  Project Overview
The API Governance System is a backend application built using Spring Boot 
that enables structured management of APIs, user access control, and governance workflows.
It allows organizations to control API usage through request, review, and approval mechanisms while ensuring security and scalability.

---

## l Features
- User Registration & Login (JWT Authentication)
- Role-Based Access Control (Admin, Manager, User)
- API Resource Management
- API Access Request & Approval Workflow
- Manager Review & Admin Approval System
- API Usage Logging
- Customer Management
- Payment Management
- Global Exception Handling
- DTO & Mapper-based architecture
- Secure REST APIs using Spring Security

---

## 🏗️ Tech Stack
- Java
- Spring Boot
- Spring Security (JWT)
- Spring Data JPA
- MySQL

---

## 📂 Project Structure
controller
service
service.impl
repository
entity
dto
exception
security
config 


---

##  How to Run the Project
1. Clone the repository  
2. Open the project in IntelliJ IDEA / Eclipse  
3. Configure MySQL database in `application.properties`  
4. Run the main Spring Boot application  
5. Use Postman or any API client to test endpoints  

---

##  Authentication APIs
- **POST** `/auth/register` → Register new user  
- **POST** `/auth/login` → Login and get JWT token  

---

##  API Resource Management
- **POST** `/api-resource/create` → Create API resource  
- **GET** `/api-resource/all` → Get all API resources  

---

##  API Usage Logs
- **POST** `/usage/log` → Log API usage  
- **GET** `/usage/all` → Get usage logs  

---

##  Customer APIs
- **POST** `/customer/add` → Add customer  

---

##  Payment APIs
- **POST** `/payment/add` → Add payment  

---

##  Governance APIs
- **POST** `/governance/request` → Request API access  

---

##  Manager APIs
- **PUT** `/manager/review/{requestId}` → Review API request  

---

##  Admin APIs
- **PUT** `/admin/approve/{requestId}` → Approve request  
- **PUT** `/admin/reject/{requestId}` → Reject request  
- **DELETE** `/admin/delete/{requestId}` → Delete request  
- **DELETE** `/admin/delete/multiple` → Delete multiple requests  

---

##  Reports
- **GET** `/report/generate` → Generate reports  

---

##  Security
- JWT-based authentication  
- Role-based authorization  
- Secure endpoints using Spring Security  
