package io.github.thang86.weather.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * ThangTX2
 */
data class RequestInfo (
    @SerializedName("success")
    @Expose
    val success:Boolean
)