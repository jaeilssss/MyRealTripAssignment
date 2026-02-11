package org.com.myrealtripassignment.application.reservation.out

import org.com.myrealtripassignment.domain.entity.Reservation

interface ReservationOutPort {
    fun save(reservation: Reservation): Reservation
    fun findById(reservationId: Long): Reservation
}