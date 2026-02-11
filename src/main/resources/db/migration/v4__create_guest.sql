CREATE TABLE guest (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       email VARCHAR(255),
                       phone VARCHAR(50),
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);