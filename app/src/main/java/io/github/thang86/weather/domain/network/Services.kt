package io.github.thang86.weather.domain.network

import io.github.thang86.weather.domain.model2.SearchRespone
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

/**
 * ThangTX2
 */
interface Services {

//    @GET("/live/locations")
//    fun getLocation(@Query("api_key") key: String, @Query("q") query: String): Call<SearchRespone>
//
//    @GET("/live/locations")
//    fun getLocation(@QueryMap params: Map<String, String>): Call<SearchRespone>

    @GET("/REST/v1/Locations")
    fun getLocations(@QueryMap params: Map<String, String>): Call<SearchRespone>

    @GET("/REST/v1/Locations")
    fun getLocation( @Query("q") query: String,@Query("key") key: String): Call<SearchRespone>
}