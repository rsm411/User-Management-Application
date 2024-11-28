-- Create the database
CREATE DATABASE hackathon_app;

-- Connect to the database
\c hackathon_app;

-- Create the Users table
CREATE TABLE Users (
    user_id VARCHAR(255) PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255),
    age INT
);