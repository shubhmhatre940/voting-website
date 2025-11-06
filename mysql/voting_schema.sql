-- MySQL script to create database and tables for demo voting app
CREATE DATABASE IF NOT EXISTS votingdb;
USE votingdb;

CREATE TABLE IF NOT EXISTS voters (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(200),
  address VARCHAR(500),
  phone VARCHAR(50),
  email VARCHAR(200) UNIQUE,
  aadhar VARCHAR(50),
  dob VARCHAR(50),
  password VARCHAR(200),
  has_voted BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS candidates (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(200),
  party VARCHAR(200),
  manifesto TEXT,
  votes INT DEFAULT 0
);

-- Optional: seed admin credentials are handled client-side for demo (admin/admin123)
-- Seed sample candidates
INSERT INTO candidates (name, party, manifesto) VALUES
('Alice Kumar','Party A','Focus on education'),
('Bob Singh','Party B','Healthcare and jobs');
