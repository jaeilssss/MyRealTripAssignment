package org.com.myrealtripassignment.application.reservation.service

import org.com.myrealtripassignment.application.reservation.`in`.ReservationCancelCommand
import org.com.myrealtripassignment.application.reservation.`in`.ReservationCommand
import org.com.myrealtripassignment.application.reservation.`in`.ReservationQuery
import org.com.myrealtripassignment.application.reservation.`in`.ReservationUseCase
import org.com.myrealtripassignment.application.reservation.out.GuestOutPort
import org.com.myrealtripassignment.application.reservation.out.ReservationOutPort
import org.com.myrealtripassignment.application.reservation.out.ReservationResponse
import org.com.myrealtripassignment.application.reservation.out.RoomInventoryOutPort
import org.com.myrealtripassignment.application.reservation.out.RoomInventoryResponse
import org.com.myrealtripassignment.application.reservation.out.RoomTypeOutPort
import org.com.myrealtripassignment.domain.entity.Reservation
import org.com.myrealtripassignment.domain.enums.ReservationStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal
import java.time.LocalDate

@Service
class ReservationService(
    private val inventoryRepository: RoomInventoryOutPort,
): ReservationUseCase {
    @Transactional(readOnly = true)
    override fun getRoomInventory(roomTypeId: Long, date: LocalDate): RoomInventoryResponse {
        val inventory = inventoryRepository.findByRoomTypeAndDate(roomTypeId, date)
            ?: throw IllegalArgumentException("재고 정보가 없습니다.")

        return RoomInventoryResponse(
            roomTypeId = roomTypeId,
            date = date,
            totalRooms = inventory.totalRooms,
            availableRooms = inventory.availableRooms
        )
    }

    override fun createReservation(request: ReservationCommand): ReservationResponse {
        TODO("Not yet implemented")
    }

    override fun getReservation(reservationId: Long): ReservationResponse {
        TODO("Not yet implemented")
    }

    override fun cancelReservation(reservationId: Long) {
        TODO("Not yet implemented")
    }

}