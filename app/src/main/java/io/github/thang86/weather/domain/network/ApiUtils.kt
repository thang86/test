package io.github.thang86.weather.domain.network

import io.github.thang86.weather.BuildConfig

/**
 * ThangTX2
 */
class ApiUtils {
    companion object {
        fun getResult(): Services {
            return ApiClient.getApiClient(BuildConfig.BING_URL).create(Services::class.java)
        }
    }
}