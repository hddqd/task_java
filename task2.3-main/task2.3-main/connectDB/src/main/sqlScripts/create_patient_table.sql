CREATE TABLE IF NOT EXISTS patient (
    id VARCHAR(36) PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    date_of_birth DATE,
    address VARCHAR(100),
    phone_number VARCHAR(20),
    email_address VARCHAR(50),
    FOREIGN KEY (hospital_id) REFERENCES hospital (id) ON DELETE CASCADE
);
