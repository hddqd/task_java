CREATE TABLE IF NOT EXISTS medical_card (
    id VARCHAR(36) PRIMARY KEY,
    creation_date DATE,
    diagnosis VARCHAR(255),
    attending_doctor VARCHAR(36),
    FOREIGN KEY (attending_doctor) REFERENCES doctor (id) ON DELETE SET NULL
);
