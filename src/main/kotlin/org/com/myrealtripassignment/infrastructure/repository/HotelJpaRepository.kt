package org.com.myrealtripassignment.infrastructure.repository

import org.com.myrealtripassignment.domain.entity.Hotel
import org.springframework.data.jpa.repository.JpaRepository

interface HotelJpaRepository: JpaRepository<Hotel, Long> {
}