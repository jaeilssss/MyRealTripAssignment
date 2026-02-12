package org.com.myrealtripassignment.infrastructure.adapter

import org.com.myrealtripassignment.application.reservation.out.RoomTypeOutPort
import org.com.myrealtripassignment.domain.entity.RoomType
import org.com.myrealtripassignment.infrastructure.repository.RoomTypeJpaRepository
import org.springframework.stereotype.Repository

@Repository
class RoomTypePersistenceAdapter (
    private val roomTypeJpaRepository: RoomTypeJpaRepository
) : RoomTypeOutPort{
    override fun findById(id: Long): RoomType? =
        roomTypeJpaRepository.findById(id).orElse(null)
}