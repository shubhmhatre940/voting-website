# Voting App Demo

## What is included
- Minimal Spring Boot backend (REST API) using Spring Data JPA.
- Static frontend (HTML/JS) served from `src/main/resources/static`.
- MySQL script: `mysql/voting_schema.sql` to create database and seed two candidates.

## How to run
1. Install Java 17+, Maven, and MySQL.
2. Create the database using `mysql/voting_schema.sql` or let JPA auto-create tables.
3. Update `src/main/resources/application.properties` with your MySQL username/password.
4. From project root run:
   ```
   mvn spring-boot:run
   ```
5. Open `http://localhost:8080` in your browser.

## Notes / Security
- This is a demo. Passwords are stored plaintext for simplicity — **do not** use this in production.
- No CSRF protection or production hardened auth. Use Spring Security and password hashing (BCrypt) for real systems.
