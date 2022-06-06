package com.example.repositoriosgithub.data.repositories

import com.example.repositoriosgithub.data.services.GitHubService
import kotlinx.coroutines.flow.flow

class RepoRepositoriesImpl(private val service: GitHubService) : RepoRepository{
    override suspend fun listRepositories(user: String) = flow {
        val repoList = service.listRepositories(user)
        emit(repoList)
    }
}