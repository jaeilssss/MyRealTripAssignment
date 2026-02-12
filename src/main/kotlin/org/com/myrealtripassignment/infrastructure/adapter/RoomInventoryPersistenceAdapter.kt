package org.com.myrealtripassignment.infrastructure.adapter

import org.com.myrealtripassignment.application.reservation.out.RoomInventoryOutPort
import org.com.myrealtripassignment.domain.entity.RoomInventory
import org.com.myrealtripassignment.infrastructure.repository.RoomInventoryJpaRepository
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class RoomInventoryPersistenceAdapter(
    private val jpaRepository: RoomInventoryJpaRepository
): RoomInventoryOutPort {
    override fun findByRoomTypeAndDateForUpdate(roomTypeId: Long, date: LocalDate): RoomInventory? =
        jpaRepository.findByRoomTypeIdAndDateForUpdate(roomTypeId, date)

    override fun findByRoomTypeAndDate(roomTypeId: Long, date: LocalDate): RoomInventory? =
        jpaRepository.findByRoomTypeIdAndDate(roomTypeId, date)

    override fun save(inventory: RoomInventory): RoomInventory =
        jpaRepository.save(inventory)
}