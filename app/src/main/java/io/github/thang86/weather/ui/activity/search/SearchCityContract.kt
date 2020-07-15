package io.github.thang86.weather.ui.activity.search

import io.github.thang86.weather.domain.model2.SearchRespone
import retrofit2.Response


/**
 * ThangTX2
 */
interface SearchCityContract {
    interface CityIntractor {
        fun getCityByNames(
            apiKey: String, query: String,
            listener: OnFinishedListener
        )
    }

    interface OnFinishedListener {
        fun onSuccess(response: Response<SearchRespone>)
        fun onError(response: Response<SearchRespone>)
        fun onFailure(throwable: Throwable?)

    }
}