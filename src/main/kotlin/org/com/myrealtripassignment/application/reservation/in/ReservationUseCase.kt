package org.com.myrealtripassignment.application.reservation.`in`

interface ReservationUseCase {
    fun reserve(command: ReservationCommand)
    fun cancel(command: ReservationCancelCommand)
    fun search(hotelId: Long): List<ReservationQuery>
}