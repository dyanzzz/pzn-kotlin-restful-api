package imu.creative.kotlin.restful.api.error

import imu.creative.kotlin.restful.api.entity.Product
import java.util.*

class AlreadyExistException(val product: Product): Exception() {
}