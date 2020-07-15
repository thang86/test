package io.github.thang86.weather.ui.activity.search

import android.util.Log
import io.github.thang86.weather.domain.model2.SearchRespone
import io.github.thang86.weather.domain.network.ApiUtils
import retrofit2.Callback
import retrofit2.Response

/**
 * ThangTX2
 */
class GetCityIntractor : SearchCityContract.CityIntractor {

    override fun getCityByNames(
        apiKey: String,
        query: String,
        listener: SearchCityContract.OnFinishedListener
    ) {
        try {

            var params = HashMap<String, String>()
            params["q"] = query
            params["maxResults"] = 20.toString()
            params["key"] = apiKey


            var callback = ApiUtils.getResult().getLocations(params)

            callback.enqueue(object : Callback<SearchRespone> {
                override fun onFailure(call: retrofit2.Call<SearchRespone>, t: Throwable) {
                    listener.onFailure(t);
                }

                override fun onResponse(
                    call: retrofit2.Call<SearchRespone>,
                    response: Response<SearchRespone>
                ) {
                    if (response.isSuccessful) {
                        listener.onSuccess(response)
                    } else {
                        listener.onError(response)
                    }
                }

            })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


}