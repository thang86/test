package io.github.thang86.weather.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * ThangTX2
 */
data class SearchRespone(
    @SerializedName("request_info")
    @Expose
    val requestInfo: RequestInfo,

    @SerializedName("locations_total")
    @Expose
    private val locationsTotal: Int? = null,

    @SerializedName("page")
    @Expose
    private val page: Int? = null,

    @SerializedName("limit")
    @Expose
    private val limit: Int? = null,

    @SerializedName("locations")
    @Expose val locations: List<Location>? = null

)