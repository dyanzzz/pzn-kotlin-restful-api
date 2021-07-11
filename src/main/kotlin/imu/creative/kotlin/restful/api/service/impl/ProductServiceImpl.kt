package imu.creative.kotlin.restful.api.service.impl

import imu.creative.kotlin.restful.api.entity.Product
import imu.creative.kotlin.restful.api.error.AlreadyExistException
import imu.creative.kotlin.restful.api.error.NotFoundException
import imu.creative.kotlin.restful.api.model.CreateProductRequest
import imu.creative.kotlin.restful.api.model.ListProductRequest
import imu.creative.kotlin.restful.api.model.ProductResponse
import imu.creative.kotlin.restful.api.model.UpdateProductRequest
import imu.creative.kotlin.restful.api.repository.ProductRepository
import imu.creative.kotlin.restful.api.service.ProductService
import imu.creative.kotlin.restful.api.validation.ValidationUtil
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

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
        val product = findProductByIdOrThrowNotFound(id)

        return convertProductToProductResponse(product)
    }

    override fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse {
        val product = findProductByIdOrThrowNotFound(id)

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

    override fun delete(id: String): ProductResponse {

        val product = findProductByIdOrThrowNotFound(id)

        productRepository.delete(product)
        return convertProductToProductResponse(product)
    }

    override fun list(listProductRequest: ListProductRequest): List<ProductResponse> {
        val page = productRepository.findAll(PageRequest.of(
            listProductRequest.page,
            listProductRequest.size
        ))

        println("page : ${page.number}")
        println("size : ${page.size}")
        println("total page in page ${page.number} : ${page.numberOfElements}")
        println("total elements per page : ${page.totalPages}")
        println("total elements : ${page.totalElements}")

        val products: List<Product> = page.get().collect(Collectors.toList())

        return products.map {
            convertProductToProductResponse(it)
        }
    }

    private fun findProductByIdOrThrowNotFound(id: String): Product {
        // get id dari product repository
        val product = productRepository.findByIdOrNull(id)
        if (product == null) {
            throw NotFoundException()
        } else {
            return product
        }
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