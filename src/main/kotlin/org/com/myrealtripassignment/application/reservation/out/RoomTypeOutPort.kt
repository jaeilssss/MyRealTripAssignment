package org.com.myrealtripassignment.application.reservation.out

import org.com.myrealtripassignment.domain.entity.RoomType

interface RoomTypeOutPort {
    fun findById(id: Long): RoomType?
}