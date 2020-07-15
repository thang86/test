package io.github.thang86.weather.domain.model2

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * ThangTX2
 */
data class Address(

    @SerializedName("adminDistrict")
    @Expose
    val adminDistrict: String,

    @SerializedName("countryRegion")
    @Expose
    val countryRegion: String,

    @SerializedName("formattedAddress")
    @Expose
    val formattedAddress: String,

    @SerializedName("locality")
    @Expose
    val locality: String,

    @SerializedName("adminDistrict2")
    @Expose
    val adminDistrict2: String
)