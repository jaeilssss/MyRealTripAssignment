package org.com.myrealtripassignment.domain.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "hotel")
class Hotel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var name: String,

    @Column(length = 500)
    var address: String? = null,

    @Column(nullable = false, updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()
)