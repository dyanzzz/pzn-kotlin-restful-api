package imu.creative.kotlin.restful.api.controller

import imu.creative.kotlin.restful.api.model.CreateProductRequest
import imu.creative.kotlin.restful.api.model.ProductResponse
import imu.creative.kotlin.restful.api.model.WebResponse
import imu.creative.kotlin.restful.api.service.ProductService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

// pastikan productController ini manggil productService dari constructor
@RestController
class ProductController(val productService: ProductService) {

    @PostMapping(
        value = ["/api/product"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createProduct(@RequestBody body: CreateProductRequest): WebResponse<ProductResponse> {
        val productResponse = productService.create(body)

        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }
}