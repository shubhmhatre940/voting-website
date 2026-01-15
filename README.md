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
![WhatsApp Image 2026-01-15 at 6 27 26 PM](https://github.com/user-attachments/assets/a77ef09c-4183-4384-9927-6976425ce51a)
![WhatsApp Image 2026-01-15 at 6 27 28 PM](https://github.com/user-attachments/assets/155039be-4633-4ca6-b6bd-f49a910b4b1c)
![WhatsApp Image 2026-01-15 at 6 27 28 PM (1)](https://github.com/user-attachments/assets/8ae646b1-7d72-4227-b7b4-4f5b9aa521be)
![WhatsApp Image 2026-01-15 at 6 27 28 PM (2)](https://github.com/user-attachments/assets/52413613-5dd2-4746-88b4-822ecd9b7d8d)
![WhatsApp Image 2026-01-15 at 6 27 26 PM (1)](https://github.com/user-attachments/assets/2961f61b-cf90-4b8c-b06a-0d016d70db5b)
![WhatsApp Image 2026-01-15 at 6 27 26 PM (2)](https://github.com/user-attachments/assets/b6dc938e-fa36-472e-82b1-465cb3e98f08)
![WhatsApp Image 2026-01-15 at 6 27 27 PM](https://github.com/user-attachments/assets/58186c4d-6bab-4d31-975c-b3e66d57cb66)
![WhatsApp Image 2026-01-15 at 6 27 27 PM (1)](https://github.com/user-attachments/assets/a72b8579-988d-4bf0-9983-03c526c04dbf)
![WhatsApp Image 2026-01-15 at 6 27 27 PM (2)](https://github.com/user-attachments/assets/c0635c36-37c5-481e-b8e3-29e7e3485ad6)
