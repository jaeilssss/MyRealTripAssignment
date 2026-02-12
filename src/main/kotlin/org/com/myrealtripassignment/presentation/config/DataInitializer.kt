package org.com.myrealtripassignment.presentation.config
import org.com.myrealtripassignment.domain.entity.*
import org.com.myrealtripassignment.infrastructure.repository.HotelJpaRepository
import org.com.myrealtripassignment.infrastructure.repository.RoomInventoryJpaRepository
import org.com.myrealtripassignment.infrastructure.repository.RoomTypeJpaRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.math.BigDecimal
import java.time.LocalDate

@Configuration
class DataInitializer {

    @Bean
    fun initData(
        hotelRepository: HotelJpaRepository,
        roomTypeRepository: RoomTypeJpaRepository,
        inventoryRepository: RoomInventoryJpaRepository
    ) = ApplicationRunner {

        // 이미 데이터 있으면 종료
        if (hotelRepository.count() > 0) return@ApplicationRunner

        // 1️⃣ 호텔 생성
        val hotel = hotelRepository.save(
            Hotel(
                name = "MyRealTrip Hotel",
                address = "Seoul, Korea"
            )
        )

        // 2️⃣ 룸타입 생성
        val standard = roomTypeRepository.save(
            RoomType(
                hotel = hotel,
                name = "Standard",
                capacity = 2,
                basePrice = BigDecimal("120.00")
            )
        )

        val deluxe = roomTypeRepository.save(
            RoomType(
                hotel = hotel,
                name = "Deluxe",
                capacity = 4,
                basePrice = BigDecimal("200.00")
            )
        )

        // 3️⃣ 30일치 재고 생성
        val today = LocalDate.now()
        val totalRoomsStandard = 10
        val totalRoomsDeluxe = 5

        for (i in 0 until 30) {
            val date = today.plusDays(i.toLong())

            inventoryRepository.save(
                RoomInventory(
                    roomType = standard,
                    date = date,
                    totalRooms = totalRoomsStandard,
                    availableRooms = totalRoomsStandard
                )
            )

            inventoryRepository.save(
                RoomInventory(
                    roomType = deluxe,
                    date = date,
                    totalRooms = totalRoomsDeluxe,
                    availableRooms = totalRoomsDeluxe
                )
            )
        }

        println("초기 데이터 세팅 완료")
    }
}