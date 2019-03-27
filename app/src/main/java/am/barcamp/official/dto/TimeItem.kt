package am.barcamp.official.dto

import com.google.gson.annotations.SerializedName

data class TimeItem(
    val date: String,
    @SerializedName("timezone_type")
    val timezoneType: Int,
    val timezone: String
)