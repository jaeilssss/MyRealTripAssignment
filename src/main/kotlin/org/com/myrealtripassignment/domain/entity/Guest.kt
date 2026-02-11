package org.com.myrealtripassignment.domain.entity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "guest")
class Guest(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var name: String,

    @Column
    var email: String? = null,

    @Column
    var phone: String? = null,

    @Column(nullable = false, updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()
)