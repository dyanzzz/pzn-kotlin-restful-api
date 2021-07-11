package imu.creative.kotlin.restful.api.repository

import imu.creative.kotlin.restful.api.entity.ApiKey
import org.springframework.data.jpa.repository.JpaRepository

interface ApiKeyRepository: JpaRepository<ApiKey, String> {
}