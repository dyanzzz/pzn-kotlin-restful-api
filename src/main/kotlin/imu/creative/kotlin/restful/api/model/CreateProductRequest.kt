package imu.creative.kotlin.restful.api.model

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

// request body
data class CreateProductRequest (
    // default field ini semuanya adalah nullable

    @field:NotBlank
    val id: String,

    @field:NotBlank
    val name: String,

    @field:NotNull
    @field:Min(value = 1)
    val price: Long,

    @field:NotNull
    @field:Min(value = 0)
    val quantity: Int
)