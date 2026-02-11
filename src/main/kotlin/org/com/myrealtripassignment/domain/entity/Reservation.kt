package org.com.myrealtripassignment.domain.entity

import jakarta.persistence.*
import org.com.myrealtripassignment.domain.enums.ReservationStatus
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "reservation")
class Reservation(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guest_id", nullable = false)
    val guest: Guest,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", nullable = false)
    val hotel: Hotel,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_type_id", nullable = false)
    val roomType: RoomType,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var status: ReservationStatus,

    @Column(nullable = false)
    val checkInDate: LocalDate,

    @Column(nullable = false)
    val checkOutDate: LocalDate,

    @Column(nullable = false)
    var totalPrice: BigDecimal,

    @Column(nullable = false, updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()
)