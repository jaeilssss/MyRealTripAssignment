package org.com.myrealtripassignment.application.reservation.out

import java.time.LocalDate

data class RoomInventoryResponse(
    val roomTypeId: Long,
    val date: LocalDate,
    val totalRooms: Int,
    val availableRooms: Int
)