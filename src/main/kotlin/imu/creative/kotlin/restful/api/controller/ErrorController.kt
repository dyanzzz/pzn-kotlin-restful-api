package imu.creative.kotlin.restful.api.controller

import imu.creative.kotlin.restful.api.model.WebResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorController {

    // kalo ada throw exception, dan typenya adalah ConstraintViolationException, maka akan ditangkap oleh function ini
    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintsViolationException: ConstraintViolationException): WebResponse<String> {
        return WebResponse(
            code = 400,
            status = "Bad Request",
            data = constraintsViolationException.message!!
        )
    }
}