package imu.creative.kotlin.restful.api.controller

import imu.creative.kotlin.restful.api.model.CreateProductRequest
import imu.creative.kotlin.restful.api.model.ProductResponse
import imu.creative.kotlin.restful.api.model.UpdateProductRequest
import imu.creative.kotlin.restful.api.model.WebResponse
import imu.creative.kotlin.restful.api.service.ProductService
import org.springframework.web.bind.annotation.*

// pastikan productController ini manggil productService dari constructor
@RestController
class ProductController(val productService: ProductService) {

    @PostMapping(
        value = ["/api/product"],
        produces = ["application/json"],    // produces == response
        consumes = ["application/json"]     // consumes == ada body dalam type json
    )
    fun createProduct(@RequestBody body: CreateProductRequest): WebResponse<ProductResponse> {
        val productResponse = productService.create(body)

        return convertProductResponseToWebResponse("Save Product Success", productResponse)
    }

    // pathVariable => ketika menambahkan uri dengan id, maka id akan digunakan ke parameter function get product
    @GetMapping(
        value = ["/api/product/{id}"],
        produces = ["application/json"] // produces == response
    )
    fun getProduct(@PathVariable("id") id: String): WebResponse<ProductResponse> {
        val productResponse = productService.get(id)

        return convertProductResponseToWebResponse("OK", productResponse)
    }

    @PutMapping(
        value = ["/api/product/{id}"],
        produces = ["application/json"],    // produces == response
        consumes = ["application/json"]     // consumes == ada body dalam type json
    )
    fun updateProduct(
        @PathVariable("id") id: String,
        @RequestBody body: UpdateProductRequest
    ): WebResponse<ProductResponse> {

        val productResponse = productService.update(id, body)

        return convertProductResponseToWebResponse("Update Product Success", productResponse)
    }

    @DeleteMapping(
        value = ["/api/product/{id}"],
        produces = ["application/json"],    // produces == response
    )
    fun deleteProduct(
        @PathVariable("id") id: String
    ): WebResponse<ProductResponse> {

        val productResponse = productService.delete(id)

        return convertProductResponseToWebResponse("Delete Product Success", productResponse)
    }

    private fun convertProductResponseToWebResponse(
        status: String,
        productResponse: ProductResponse
    ): WebResponse<ProductResponse> {
        return WebResponse(
            code = 200,
            status = status,
            data = productResponse
        )
    }
}