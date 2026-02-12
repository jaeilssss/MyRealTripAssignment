package org.com.myrealtripassignment.infrastructure.repository

import org.com.myrealtripassignment.domain.entity.Guest
import org.springframework.data.jpa.repository.JpaRepository

interface GuestJpaRepository : JpaRepository<Guest, Long> {
    fun findByEmail(email: String): Guest?
}
