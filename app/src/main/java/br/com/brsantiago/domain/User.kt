package br.com.brsantiago.domain

import com.google.gson.annotations.SerializedName

data class User(
    val login: String,
    @SerializedName("avatar_url") val avatar: String,
    val url: String,
    val type: String, val id: Int
)