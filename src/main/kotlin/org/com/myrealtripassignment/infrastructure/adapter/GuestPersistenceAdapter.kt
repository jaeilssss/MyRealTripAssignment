package org.com.myrealtripassignment.infrastructure.adapter

import org.com.myrealtripassignment.application.reservation.out.GuestOutPort
import org.com.myrealtripassignment.domain.entity.Guest
import org.com.myrealtripassignment.infrastructure.repository.GuestJpaRepository
import org.springframework.stereotype.Repository


@Repository
class GuestPersistenceAdapter(
    private val jpaRepository: GuestJpaRepository
) : GuestOutPort {

    override fun findById(id: Long): Guest? =
        jpaRepository.findById(id).orElse(null)

    override fun findByEmail(email: String): Guest? =
        jpaRepository.findByEmail(email)

    override fun save(guest: Guest): Guest =
        jpaRepository.save(guest)
}