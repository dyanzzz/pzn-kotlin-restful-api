package imu.creative.kotlin.restful.api.repository

import imu.creative.kotlin.restful.api.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, String>