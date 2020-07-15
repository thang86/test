package io.github.thang86.weather.domain.model2

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * ThangTX2
 */
data class Point (

    @SerializedName("type")
    @Expose
    val type:String,

    @SerializedName("coordinates")
    @Expose
    val coordinates:List<Double>


)