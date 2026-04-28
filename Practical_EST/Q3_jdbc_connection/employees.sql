CREATE DATABASE IF NOT EXISTS company_db;
USE company_db;

CREATE TABLE IF NOT EXISTS employees (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    department VARCHAR(100) NOT NULL,
    salary DECIMAL(10, 2) NOT NULL
);

INSERT INTO employees (id, name, email, department, salary) VALUES
    (1, 'Aarav Sharma', 'aarav.sharma@example.com', 'Engineering', 75000.00),
    (2, 'Diya Patel', 'diya.patel@example.com', 'Human Resources', 52000.00),
    (3, 'Rohan Gupta', 'rohan.gupta@example.com', 'Finance', 68000.00);
