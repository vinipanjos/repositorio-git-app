package com.example.repositoriosgithub.data.services

import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("users/{user}/repos")
    suspend fun listRepositories(@Path("user")user : String): List<Repo>
}