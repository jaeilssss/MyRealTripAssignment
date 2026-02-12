package org.com.myrealtripassignment.application.reservation.out

import org.com.myrealtripassignment.domain.entity.Reservation
import java.util.Optional

interface ReservationOutPort {
    fun save(reservation: Reservation): Reservation
    fun findById(reservationId: Long): Optional<Reservation>
}