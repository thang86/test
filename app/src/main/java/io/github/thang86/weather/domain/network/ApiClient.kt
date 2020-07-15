package io.github.thang86.weather.domain.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


/**
 * ThangTX2
 */
class ApiClient {
    companion object {
        private  var retrofit: Retrofit ?=null;

        fun getApiClient(baseUrl: String): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()

            }
            return retrofit!!
        }
    }
}


