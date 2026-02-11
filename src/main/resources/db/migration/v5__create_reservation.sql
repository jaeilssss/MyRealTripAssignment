CREATE TABLE reservation (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             guest_id BIGINT NOT NULL,
                             hotel_id BIGINT NOT NULL,
                             room_type_id BIGINT NOT NULL,
                             status VARCHAR(50) NOT NULL, -- CREATED, CONFIRMED, CANCELLED
                             check_in_date DATE NOT NULL,
                             check_out_date DATE NOT NULL,
                             total_price DECIMAL(12, 2) NOT NULL,
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                             CONSTRAINT fk_reservation_guest FOREIGN KEY (guest_id) REFERENCES guest(id),
                             CONSTRAINT fk_reservation_hotel FOREIGN KEY (hotel_id) REFERENCES hotel(id),
                             CONSTRAINT fk_reservation_room_type FOREIGN KEY (room_type_id) REFERENCES room_type(id)
);