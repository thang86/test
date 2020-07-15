package io.github.thang86.weather.domain.model2

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * ThangTX2
 */
data class SearchRespone(
    @SerializedName("authenticationResultCode")
    @Expose
    val authenticationResultCode: String,

    @SerializedName("brandLogoUri")
    @Expose
    val brandLogoUri: String,

    @SerializedName("copyright")
    @Expose
    val copyright: String,

    @SerializedName("resourceSets")
    @Expose
    val resourceSets: List<ResourceSet>,

    @SerializedName("statusCode")
    @Expose
    val statusCode: Int,

    @SerializedName("statusDescription")
    @Expose
    val statusDescription: String,

    @SerializedName("traceId")
    @Expose
    val traceId: String
)