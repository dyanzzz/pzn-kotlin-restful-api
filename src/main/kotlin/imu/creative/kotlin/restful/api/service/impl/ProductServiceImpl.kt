package imu.creative.kotlin.restful.api.service.impl

import imu.creative.kotlin.restful.api.entity.Product
import imu.creative.kotlin.restful.api.error.AlreadyExistException
import imu.creative.kotlin.restful.api.error.NotFoundException
import imu.creative.kotlin.restful.api.model.CreateProductRequest
import imu.creative.kotlin.restful.api.model.ProductResponse
import imu.creative.kotlin.restful.api.model.UpdateProductRequest
import imu.creative.kotlin.restful.api.repository.ProductRepository
import imu.creative.kotlin.restful.api.service.ProductService
import imu.creative.kotlin.restful.api.validation.ValidationUtil
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import javax.validation.ConstraintViolationException

// productRepository dijadikan sebagai field => diberikan inisialisasi variable val
@Service
class ProductServiceImpl(
    // constructor
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
        val findProductByName = productRepository.findFirstByName(product.name)
        val findProductById = productRepository.existsById(product.id)

        println(findProductByName)

        when {
            (findProductById) || (findProductByName != null) -> {
                throw AlreadyExistException(product)
            }
            else -> {
                productRepository.save(product)
                return convertProductToProductResponse(product)
            }
        }
    }

    override fun get(id: String): ProductResponse {
        // get id dari product repository
        val product = productRepository.findByIdOrNull(id)
        if (product == null) {
            throw NotFoundException()
        } else {
            return convertProductToProductResponse(product)
        }
    }

    override fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse {
        // cek dulu, ada ga idnya
        val product = productRepository.findByIdOrNull(id) ?: throw NotFoundException()

        // sebelum mengeksekusi service/ tiap masuk service ini, akan melakukan validasi dulu
        // jika ada masalah, maka akan throw ConstraintViolationException
        validationUtil.validate(updateProductRequest)

        // ubah nama, dan field lain mengikuti requestnya
        product.apply {
            name = updateProductRequest.name
            price = updateProductRequest.price
            quantity = updateProductRequest.quantity
            updatedDate = Date()
        }

        productRepository.save(product)
        return convertProductToProductResponse(product)
    }

    private fun convertProductToProductResponse(product: Product): ProductResponse {
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