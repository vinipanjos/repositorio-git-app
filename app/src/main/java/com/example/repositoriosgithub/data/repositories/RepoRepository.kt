package com.example.repositoriosgithub.data.repositories

import com.example.repositoriosgithub.data.model.Repo
import kotlinx.coroutines.flow.Flow

interface RepoRepository {
    suspend fun listRepositories(user:String): Flow<List<Repo>>
}