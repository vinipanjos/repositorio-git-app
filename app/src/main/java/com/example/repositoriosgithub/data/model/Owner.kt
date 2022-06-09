package com.example.repositoriosgithub.data.model

import com.google.gson.annotations.SerializedName

data class Owner (
    val login: String,
    @SerializedName("avatar_url")
    val avatarURL: String
    )
