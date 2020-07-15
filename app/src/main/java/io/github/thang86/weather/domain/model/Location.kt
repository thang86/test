package io.github.thang86.weather.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * ThangTX2
 */
data class Location(
    @SerializedName("id") @Expose
    private var id: Int? = null,

    @SerializedName("name")
    @Expose val name: String? = null,

    @SerializedName("type")
    @Expose
    private val type: String? = null,

    @SerializedName("full_name")
    @Expose val fullName: String? = null,

    @SerializedName("parent_id")
    @Expose
    private val parentId: Int? = null,

    @SerializedName("country_code")
    @Expose
    private val countryCode: String? = null,

    @SerializedName("reach")
    @Expose
    private val reach: Int? = null
)