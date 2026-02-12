package org.com.myrealtripassignment.application.reservation.`in`

import java.time.LocalDate

class ReservationCommand (
    val guestId: Long,
    val roomTypeId: Long,
    val checkInDate: LocalDate,
    val checkOutDate: LocalDate
)
