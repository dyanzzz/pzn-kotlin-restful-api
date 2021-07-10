package imu.creative.kotlin.restful.api.service.impl

import imu.creative.kotlin.restful.api.entity.Product
import imu.creative.kotlin.restful.api.model.CreateProductRequest
import imu.creative.kotlin.restful.api.model.ProductResponse
import imu.creative.kotlin.restful.api.repository.ProductRepository
import imu.creative.kotlin.restful.api.service.ProductService
import imu.creative.kotlin.restful.api.validation.ValidationUtil
import org.springframework.stereotype.Service
import java.util.*

// productRepository dijadikan sebagai field => diberikan inisialisasi variable val
@Service
class ProductServiceImpl(
    val productRepository: ProductRepository,
    val validationUtil: ValidationUtil
    ) : ProductService {

    // createProductRequest => parammeter dari body
    // product response => return product response
    override fun create(createProductRequest: CreateProductRequest): ProductResponse {

        // sebelum mengeksekusi service/ tiap masuk service ini, akan melakukan validasi dulu
        // jika ada masalah, maka akan throw ConstraintViolationException
        validationUtil.validate(createProductRequest)

        val product = Product(
            id = createProductRequest.id,
            name = createProductRequest.name,
            price = createProductRequest.price,
            quantity = createProductRequest.quantity,
            createdDate = Date(),
            updatedDate = null
        )

        // untuk menyimpan ke database lewat repository
        productRepository.save(product)

        return ProductResponse(
            id = product.id,
            name = product.name,
            price = product.price,
            quantity = product.quantity,
            createdDate = product.createdDate,
            updatedDate = product.updatedDate
        )
    }

}