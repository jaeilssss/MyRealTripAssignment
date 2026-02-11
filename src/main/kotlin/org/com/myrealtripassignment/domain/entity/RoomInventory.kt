package org.com.myrealtripassignment.domain.entity

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(
    name = "room_inventory",
    uniqueConstraints = [
        UniqueConstraint(columnNames = ["room_type_id", "date"])
    ]
)
class RoomInventory(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_type_id", nullable = false)
    val roomType: RoomType,

    @Column(nullable = false)
    val date: LocalDate,

    @Column(nullable = false)
    var totalRooms: Int,

    @Column(nullable = false)
    var availableRooms: Int,

    @Column(nullable = false, updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()
)