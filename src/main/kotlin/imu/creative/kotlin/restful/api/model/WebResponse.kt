package imu.creative.kotlin.restful.api.model

data class WebResponse<T>(  // jadi harus menambahkan generic type juga pada nama data classnya
    val code: Int,
    val status: String,
    val data: T // type data generic
)
