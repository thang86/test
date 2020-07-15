package io.github.thang86.weather.domain.model2

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * ThangTX2
 */
data class Resource(

    @SerializedName("__type")
    @Expose
    val type: String,

    @SerializedName("bbox")
    @Expose
    val bbox: List<Double>,

    @SerializedName("name")
    @Expose
    val name:String,

    @SerializedName("point")
    @Expose
    val point:Point,

    @SerializedName("address")
    @Expose
    val address:Address,

    @SerializedName("confidence")
    @Expose
    val confidence:String,

    @SerializedName("entityType")
    @Expose
    val entityType:String,

    @SerializedName("geocodePoints")
    @Expose
    val geocodePoints:List<GeocodePoint>,

    @SerializedName("matchCodes")
    @Expose
    val matchCodes:List<String>




)