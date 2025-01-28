# Lab 13 - Security in Java Web Applications

**Student Information:**
- Name: Talat Daylan
- Student ID: 45136

## Project Overview
This project demonstrates the implementation of security features in a Java Spring Boot application. It includes user authentication, authorization, and basic admin functionalities.

## Technologies Used
- Spring Boot 3.2.2
- Spring Security
- Spring Data JPA
- SQLite Database
- Flyway Migration
- Lombok

## Setup Instructions
1. Clone the repository
2. Copy `.env.example` to `.env`
3. Configure your database settings in `.env`
4. Run the application using: `./mvnw spring-boot:run`

## API Endpoints

### Authentication Endpoints
- `POST /api/auth/register` - Register a new user
- `POST /api/auth/login` - Login with credentials
- `GET /api/auth/profile` - Get user profile (requires authentication)

### Admin Endpoints
- `GET /api/admin/users` - List all users (requires ADMIN role)
- `POST /api/admin/users/{id}/activate` - Activate user (requires ADMIN role)
- `POST /api/admin/users/{id}/deactivate` - Deactivate user (requires ADMIN role)

## Database Schema
The application uses SQLite with the following main table:

### Users Table
- `id` (Primary Key)
- `username` (Not Null)
- `email` (Not Null, Unique)
- `password` (Not Null)
- `created_at` (Timestamp)
