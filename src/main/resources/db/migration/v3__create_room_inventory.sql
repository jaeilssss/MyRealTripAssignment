CREATE TABLE room_inventory (
                                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                room_type_id BIGINT NOT NULL,
                                date DATE NOT NULL,
                                total_rooms INT NOT NULL,
                                available_rooms INT NOT NULL,
                                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                CONSTRAINT uk_room_inventory UNIQUE (room_type_id, date),
                                CONSTRAINT fk_inventory_room_type FOREIGN KEY (room_type_id) REFERENCES room_type(id)
);