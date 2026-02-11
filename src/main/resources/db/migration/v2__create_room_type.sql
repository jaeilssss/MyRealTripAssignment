CREATE TABLE room_type (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           hotel_id BIGINT NOT NULL,
                           name VARCHAR(255) NOT NULL,
                           capacity INT NOT NULL,
                           base_price DECIMAL(10, 2) NOT NULL,
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                           CONSTRAINT fk_room_type_hotel FOREIGN KEY (hotel_id) REFERENCES hotel(id)
);