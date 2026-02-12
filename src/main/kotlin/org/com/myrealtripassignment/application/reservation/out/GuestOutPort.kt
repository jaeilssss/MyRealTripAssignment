package org.com.myrealtripassignment.application.reservation.out

import org.com.myrealtripassignment.domain.entity.Guest

interface GuestOutPort {
    fun findById(id: Long): Guest?
    fun findByEmail(email: String): Guest?
    fun save(guest: Guest): Guest

}