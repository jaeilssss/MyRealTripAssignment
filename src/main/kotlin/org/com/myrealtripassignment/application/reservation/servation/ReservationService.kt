package org.com.myrealtripassignment.application.reservation.servation

import org.com.myrealtripassignment.application.reservation.`in`.ReservationCancelCommand
import org.com.myrealtripassignment.application.reservation.`in`.ReservationCommand
import org.com.myrealtripassignment.application.reservation.`in`.ReservationQuery
import org.com.myrealtripassignment.application.reservation.`in`.ReservationUseCase
import org.com.myrealtripassignment.application.reservation.out.ReservationOutPort
import org.springframework.stereotype.Service

@Service
class ReservationService(
    private val reservationRepository: ReservationOutPort
): ReservationUseCase {
    override fun reserve(command: ReservationCommand) {
        TODO("Not yet implemented")
    }

    override fun cancel(command: ReservationCancelCommand) {
        TODO("Not yet implemented")
    }

    override fun search(hotelId: Long): List<ReservationQuery> {
        TODO("Not yet implemented")
    }
}