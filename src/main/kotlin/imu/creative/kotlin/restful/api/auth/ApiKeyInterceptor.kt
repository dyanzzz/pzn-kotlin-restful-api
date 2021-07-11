package imu.creative.kotlin.restful.api.auth

import imu.creative.kotlin.restful.api.error.UnAuthorizeException
import imu.creative.kotlin.restful.api.repository.ApiKeyRepository
import org.springframework.stereotype.Component
import org.springframework.ui.ModelMap
import org.springframework.web.context.request.WebRequest
import org.springframework.web.context.request.WebRequestInterceptor
import java.lang.Exception

@Component
class ApiKeyInterceptor(val apiKeyRepository: ApiKeyRepository): WebRequestInterceptor {
    override fun preHandle(request: WebRequest) {
        // sebelum controllernya dieksekusi
        val apiKey = request.getHeader("X-Api-Key") ?: throw UnAuthorizeException()

        if (apiKeyRepository.existsById(apiKey)) {
            throw UnAuthorizeException()
        }
    }

    override fun postHandle(request: WebRequest, model: ModelMap?) {
        // nothing
    }

    override fun afterCompletion(request: WebRequest, ex: Exception?) {
        // nothing
    }
}