package org.com.myrealtripassignment.infrastructure.repository

import org.com.myrealtripassignment.domain.entity.Reservation
import org.springframework.data.jpa.repository.JpaRepository

interface ReservationJpaRepository : JpaRepository<Reservation, Long> {
}