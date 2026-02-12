package org.com.myrealtripassignment.infrastructure.repository

import jakarta.persistence.LockModeType
import org.com.myrealtripassignment.application.reservation.out.RoomInventoryOutPort
import org.com.myrealtripassignment.domain.entity.RoomInventory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock
import org.springframework.data.jpa.repository.Query
import java.time.LocalDate

interface RoomInventoryJpaRepository : JpaRepository<RoomInventory, Long> {
    fun findByRoomTypeIdAndDate(roomTypeId: Long, date: LocalDate): RoomInventory?

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select ri from RoomInventory ri where ri.roomType.id = :roomTypeId and ri.date = :date")
    fun findByRoomTypeIdAndDateForUpdate(roomTypeId: Long, date: LocalDate): RoomInventory?
}