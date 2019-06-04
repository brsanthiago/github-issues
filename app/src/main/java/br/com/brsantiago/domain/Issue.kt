package br.com.brsantiago.domain

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Issue(
    val title: String,
    val state: String,
    val url: String,
    val user: User,
    val number: Int,
    @SerializedName("created_at") val createdDate: Date,
    @SerializedName("closed_at") val closedAt: Date? = null
)