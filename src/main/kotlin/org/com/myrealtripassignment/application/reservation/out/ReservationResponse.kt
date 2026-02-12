package org.com.myrealtripassignment.application.reservation.out

import java.math.BigDecimal
import java.time.LocalDate

data class ReservationResponse(
    val reservationId: Long,
    val guestId: Long,
    val hotelId: Long,
    val roomTypeId: Long,
    val status: String,
    val checkInDate: LocalDate,
    val checkOutDate: LocalDate,
    val totalPrice: BigDecimal
)