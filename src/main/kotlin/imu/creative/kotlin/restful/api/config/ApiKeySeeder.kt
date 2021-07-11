package imu.creative.kotlin.restful.api.config

import imu.creative.kotlin.restful.api.entity.ApiKey
import imu.creative.kotlin.restful.api.repository.ApiKeyRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

// otomatis akan dieksekusi oleh spring ketika pertama kali berjalan
// nextnya, tambahkan midleware/ filter/ interceptor kalo di spring
// ketika di hit, sebelum interceptornya sukses, maka baru controllernya di eksekusi
// jika tidak, maka requestnya akan di reject
@Component
class ApiKeySeeder(val apiKeyRepository: ApiKeyRepository): ApplicationRunner {

    val apiKey = "SECRET"

    override fun run(args: ApplicationArguments?) {
        if (!apiKeyRepository.existsById(apiKey)) {
            val entity = ApiKey(id = apiKey)
            apiKeyRepository.save(entity)
        }
    }
}