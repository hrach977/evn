package am.barcamp.official.dto

import com.google.gson.annotations.SerializedName

data class ScheduleItem(
    val id: Int,
    val en: LanguageItem,
    val hy: LanguageItem,
    @SerializedName("bg_image_url")
    val bgImageUrl: String,
    @SerializedName("time_from")
    val from: TimeItem,
    @SerializedName("time_to")
    val to: TimeItem,
    val room: String
)

