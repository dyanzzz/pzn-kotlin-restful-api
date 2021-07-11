package imu.creative.kotlin.restful.api.auth

import org.springframework.stereotype.Component
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

// perlu mengoverride class ini untuk membuat interceptor otomatis teregisttrasi
@Component
class ApiKeyConfiguration(val apiKeyInterceptor: ApiKeyInterceptor) : WebMvcConfigurer {

    override fun addInterceptors(registry: InterceptorRegistry) {
        super.addInterceptors(registry)

        registry.addWebRequestInterceptor(apiKeyInterceptor)
    }
}