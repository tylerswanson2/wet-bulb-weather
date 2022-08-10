package dev.ex4.wetbulbweather.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class APIResponse(
    @SerialName("hours_full")
    val hoursFull: List<Long>,
    val hours: List<Long>,
    val sun: List<Float>,
    val shade: List<Float>,
    val actual: List<Float>,
    @SerialName("WBranges")
    val ranges: List<List<String>>,
    val lat: Double,
    val lon: Double,
    @SerialName("nearest grid n")
    val nearestGridN: String,
    @SerialName("nearest grid m")
    val nearestGridM: String
) {
    fun getWetBulbRanges(): List<WBRange> = ranges.map { WBRange(it[0].toLong(), it[1].toFloat(), it[2].toFloat()) }
}

data class WBRange(val timestamp: Long, val min: Float, val max: Float)