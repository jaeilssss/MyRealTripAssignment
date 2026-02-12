package org.com.myrealtripassignment.infrastructure.adapter

import org.com.myrealtripassignment.application.reservation.out.ReservationOutPort
import org.com.myrealtripassignment.domain.entity.Reservation
import org.com.myrealtripassignment.infrastructure.repository.ReservationJpaRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import java.util.Optional

@Component
class ReservationPersistenceAdapter(
    private val reservationJpaRepository: ReservationJpaRepository
): ReservationOutPort {
    override fun save(reservation: Reservation): Reservation {
        return reservationJpaRepository.save(reservation)
    }

    override fun findById(reservationId: Long): Optional<Reservation> {
        return reservationJpaRepository.findById(reservationId)
    }
}