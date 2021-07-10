package imu.creative.kotlin.restful.api.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "products")
data class Product(
    @Id
    val id: String,

    @Column(name = "name")
    val name: String,

    @Column(name = "price")
    val price: Long,

    @Column(name = "quantity")
    val quantity: Int,

    @Column(name = "created_date")
    val createdDate: Date,

    @Column(name = "updated_date")
    val updatedDate: Date?
)
