package com.example.stackoverflow.data.model

import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Item(
    @SerializedName("accepted_answer_id")
    val acceptedAnswerId: Int,
    @SerializedName("answer_count")
    val answerCount: Int,
    @SerializedName("closed_date")
    val closedDate: Int,
    @SerializedName("closed_reason")
    val closedReason: String,
    @SerializedName("creation_date")
    val creationDate: Int,
    @SerializedName("is_answered")
    val isAnswered: Boolean,
    @SerializedName("last_activity_date")
    val lastActivityDate: Int,
    @SerializedName("last_edit_date")
    val lastEditDate: Int,
    @SerializedName("link")
    val link: String,
    @SerializedName("owner")
    val owner: Owner,
    @SerializedName("question_id")
    val questionId: Int,
    @SerializedName("score")
    val score: Int,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("title")
    val title: String,
    @SerializedName("view_count")
    val viewCount: Int
)