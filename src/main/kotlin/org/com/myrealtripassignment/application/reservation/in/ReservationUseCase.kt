package org.com.myrealtripassignment.application.reservation.`in`

import org.com.myrealtripassignment.application.reservation.out.ReservationResponse
import org.com.myrealtripassignment.application.reservation.out.RoomInventoryResponse
import java.time.LocalDate

interface ReservationUseCase {

    fun getRoomInventory(roomTypeId: Long, date: LocalDate): RoomInventoryResponse

    fun createReservation(request: ReservationCommand): ReservationResponse

    fun getReservation(reservationId: Long): ReservationResponse

    fun cancelReservation(reservationId: Long)
}