CREATE TABLE IF NOT EXISTS procedure (
    id VARCHAR(36) PRIMARY KEY,
    procedure_name VARCHAR(100),
    price DECIMAL(10,2),
    duration VARCHAR(50)
);
