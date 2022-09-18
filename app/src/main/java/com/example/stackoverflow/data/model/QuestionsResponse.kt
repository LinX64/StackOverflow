package com.example.stackoverflow.data.model

import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class QuestionsResponse(
    @SerializedName("has_more")
    val hasMore: Boolean,
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("quota_max")
    val quotaMax: Int,
    @SerializedName("quota_remaining")
    val quotaRemaining: Int
)