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
    private val reservationRepository: ReservationOutPort,
    private val roomTypeRepository: RoomTypeOutPort,
    private val guestRepository: GuestOutPort
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

    @Transactional
    override fun createReservation(request: ReservationCommand): ReservationResponse {
        val guest = guestRepository.findById(request.guestId)
            ?: throw IllegalArgumentException("게스트를 찾을 수 없습니다.")

        val roomType = roomTypeRepository.findById(request.roomTypeId)
            ?: throw IllegalArgumentException("룸 타입을 찾을 수 없습니다.")

        // 날짜별 재고 차감 (체크인 ~ 체크아웃 전날)
        var totalPrice = BigDecimal.ZERO
        var currentDate = request.checkInDate

        while (currentDate.isBefore(request.checkOutDate)) {
            val inventory = inventoryRepository
                .findByRoomTypeAndDateForUpdate(roomType.id, currentDate)
                ?: throw IllegalStateException("재고 정보가 없습니다: $currentDate")

            if (inventory.availableRooms <= 0) {
                throw IllegalStateException("예약 불가: $currentDate 에 잔여 객실이 없습니다.")
            }

            inventory.availableRooms -= 1
            inventoryRepository.save(inventory)

            totalPrice += roomType.basePrice
            currentDate = currentDate.plusDays(1)
        }

        val reservation = Reservation(
            guest = guest,
            hotel = roomType.hotel,
            roomType = roomType,
            status = ReservationStatus.CONFIRMED,
            checkInDate = request.checkInDate,
            checkOutDate = request.checkOutDate,
            totalPrice = totalPrice
        )

        val saved = reservationRepository.save(reservation)
        return saved.toResponse()
    }

    override fun getReservation(reservationId: Long): ReservationResponse {
        TODO("Not yet implemented")
    }

    override fun cancelReservation(reservationId: Long) {
        TODO("Not yet implemented")
    }

    private fun Reservation.toResponse(): ReservationResponse {
        return ReservationResponse(
            reservationId = this.id,
            guestId = this.guest.id,
            hotelId = this.hotel.id,
            roomTypeId = this.roomType.id,
            status = this.status.name,
            checkInDate = this.checkInDate,
            checkOutDate = this.checkOutDate,
            totalPrice = this.totalPrice
        )
    }
}