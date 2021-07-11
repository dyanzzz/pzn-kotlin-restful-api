package imu.creative.kotlin.restful.api.repository

import imu.creative.kotlin.restful.api.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProductRepository : JpaRepository<Product, String> {
    // find yg mereturn object product
    fun findFirstByName(name: String?): Product?
    // find yg mereturn optinal object product
    // fun findFirstByName(name: String?): Optional<Product?>?
}