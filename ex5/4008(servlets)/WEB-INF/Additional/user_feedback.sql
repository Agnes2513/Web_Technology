-- Drop the existing 'emergency_response' database
DROP DATABASE emergency_response;

-- Create a new 'emergency_response' database
CREATE DATABASE emergency_response;

-- Switch to the newly created database
USE emergency_response;

-- Create the 'user_feedback' table
CREATE TABLE user_feedback (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    feedback TEXT NOT NULL,
    submitted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
