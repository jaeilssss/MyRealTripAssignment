package org.com.myrealtripassignment.application.reservation.out

import jakarta.persistence.Column

class HotelResponse(
    var name: String,
    var address: String? = null,
)