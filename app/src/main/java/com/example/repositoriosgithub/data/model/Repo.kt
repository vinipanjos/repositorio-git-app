package com.example.repositoriosgithub.data.model

import retrofit2.http.Url

data class Repo(
    val id: Long,
    val name: String,
    val owner: Owner,
    val starGazersCount:Long,
    val language: String,
    val htmlUrl: String,
    val description: String
)
