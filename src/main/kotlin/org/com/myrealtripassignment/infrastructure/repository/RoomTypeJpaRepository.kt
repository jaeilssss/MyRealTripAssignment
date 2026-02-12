package org.com.myrealtripassignment.infrastructure.repository
import org.com.myrealtripassignment.domain.entity.RoomType
import org.springframework.data.jpa.repository.JpaRepository

interface RoomTypeJpaRepository : JpaRepository<RoomType, Long>     {
}