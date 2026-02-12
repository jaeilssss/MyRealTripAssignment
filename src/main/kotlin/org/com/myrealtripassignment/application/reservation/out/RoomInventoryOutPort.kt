package org.com.myrealtripassignment.application.reservation.out

import org.com.myrealtripassignment.domain.entity.RoomInventory
import java.time.LocalDate

interface RoomInventoryOutPort {
    fun findByRoomTypeAndDateForUpdate(roomTypeId: Long, date: LocalDate): RoomInventory?
    fun findByRoomTypeAndDate(roomTypeId: Long, date: LocalDate): RoomInventory?
    fun save(inventory: RoomInventory): RoomInventory
}