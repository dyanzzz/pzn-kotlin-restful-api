package imu.creative.kotlin.restful.api.controller

import imu.creative.kotlin.restful.api.error.AlreadyExistException
import imu.creative.kotlin.restful.api.error.NotFoundException
import imu.creative.kotlin.restful.api.error.UnAuthorizeException
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

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFound(notFoundException: NotFoundException): WebResponse<String> {
        return WebResponse(
            code = 404,
            status = "NOT FOUND",
            data = "Not Found"
        )
    }

    @ExceptionHandler(value = [AlreadyExistException::class])
    fun alreadyExist(alreadyExistException: AlreadyExistException): WebResponse<String> {
        return WebResponse(
            code = 404,
            status = "ALREADY EXIST",
            data = "Product ${ alreadyExistException.product.id } | ${ alreadyExistException.product.name } Already Exist"
        )
    }

    @ExceptionHandler(value = [UnAuthorizeException::class])
    fun unAuthorize(unAuthorizeException: UnAuthorizeException): WebResponse<String> {
        return WebResponse(
            code = 401,
            status = "UNAUTHORIZED",
            data = "Please put your x-api-key"
        )
    }
}