package org.com.myrealtripassignment.domain.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "room_type")
class RoomType(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", nullable = false)
    val hotel: Hotel,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var capacity: Int,

    @Column(nullable = false)
    var basePrice: BigDecimal,

    @Column(nullable = false, updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()
)