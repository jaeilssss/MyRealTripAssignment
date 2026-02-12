package org.com.myrealtripassignment.application.reservation.`in`

import java.time.LocalDate

class ReservationCommand (
    val guestName: String,
    val guestEmail: String?,
    val guestPhone: String?,
    val roomTypeId: Long,
    val checkInDate: LocalDate,
    val checkOutDate: LocalDate
)
