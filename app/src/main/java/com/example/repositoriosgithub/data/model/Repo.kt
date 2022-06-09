package com.example.repositoriosgithub.data.model

import com.google.gson.annotations.SerializedName

data class Repo(
    val id: Long,
    val name: String,
    val owner: Owner,
    @SerializedName("stargazers_count")
    val starGazersCount: Long,
    val language: String,
    @SerializedName("html_url")
    val htmlUrl: String,
    val description: String
)
