package io.github.thang86.weather.domain.model2

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * ThangTX2
 */
data class ResourceSet (

    @SerializedName("estimatedTotal")
    @Expose
    val estimatedTotal:Int,

    @SerializedName("resources")
    @Expose
    val resources:List<Resource>

)