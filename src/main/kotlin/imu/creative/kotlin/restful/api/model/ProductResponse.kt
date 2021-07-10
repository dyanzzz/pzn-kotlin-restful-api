package imu.creative.kotlin.restful.api.model

import java.util.*

data class ProductResponse(
    val id: String,
    val name: String,
    val price: Long,
    val quantity: Int,
    val createdDate: Date,
    val updatedDate: Date?
)
