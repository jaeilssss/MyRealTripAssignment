package org.com.myrealtripassignment.infrastructure.repository

import org.com.myrealtripassignment.domain.entity.Reservation
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface ReservationJpaRepository : JpaRepository<Reservation, Long> {
}