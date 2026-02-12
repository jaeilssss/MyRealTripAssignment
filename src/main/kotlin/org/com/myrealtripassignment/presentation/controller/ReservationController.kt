package org.com.myrealtripassignment.presentation.controller

import org.com.myrealtripassignment.application.reservation.`in`.ReservationCommand
import org.com.myrealtripassignment.application.reservation.`in`.ReservationUseCase
import org.com.myrealtripassignment.application.reservation.out.ReservationResponse
import org.com.myrealtripassignment.application.reservation.out.RoomInventoryResponse
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/api")
class ReservationController(
    private val reservationUseCase: ReservationUseCase
) {

    // 룸타입별 재고 조회
    @GetMapping("/room-types/{roomTypeId}/inventory")
    fun getRoomInventory(
        @PathVariable roomTypeId: Long,
        @RequestParam date: LocalDate
    ): RoomInventoryResponse {
        return reservationUseCase.getRoomInventory(roomTypeId, date)
    }

    // 예약 생성
    @PostMapping("/reservations")
    fun createReservation(
        @RequestBody request: ReservationCommand
    ): ReservationResponse {
        return reservationUseCase.createReservation(request)
    }

    // 예약 조회
    @GetMapping("/reservations/{reservationId}")
    fun getReservation(
        @PathVariable reservationId: Long
    ): ReservationResponse {
        return reservationUseCase.getReservation(reservationId)
    }

    // 예약 취소
    @DeleteMapping("/reservations/{reservationId}")
    fun cancelReservation(
        @PathVariable reservationId: Long
    ) : String{
        reservationUseCase.cancelReservation(reservationId)
        return "OK"
    }
}