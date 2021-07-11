package imu.creative.kotlin.restful.api.service

import imu.creative.kotlin.restful.api.model.CreateProductRequest
import imu.creative.kotlin.restful.api.model.ProductResponse
import imu.creative.kotlin.restful.api.model.UpdateProductRequest

// kenapa interface ?
// interface by design
// biar gampang melakukan perubahan
// bikin kontrak servicenya dulu, baru implementasinya
interface ProductService {
    // createProductRequest => parameternya
    // productResponse => responsenya
    fun create(createProductRequest: CreateProductRequest): ProductResponse

    fun get(id: String): ProductResponse

    fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse

    // void/ unit tanpa mereturn response,
    // biasakan jika id tidak ada, tinggal throw exception aja yg dihandle oleh controller exception
    fun delete(id: String): ProductResponse
}