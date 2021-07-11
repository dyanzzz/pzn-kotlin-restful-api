package imu.creative.kotlin.restful.api.service

import imu.creative.kotlin.restful.api.model.CreateProductRequest
import imu.creative.kotlin.restful.api.model.ProductResponse

// kenapa interface ?
// interface by design
// biar gampang melakukan perubahan
// bikin kontrak servicenya dulu, baru implementasinya
interface ProductService {
    // createProductRequest => parameternya
    // productResponse => responsenya
    fun create(createProductRequest: CreateProductRequest): ProductResponse

    fun get(id: String): ProductResponse
}