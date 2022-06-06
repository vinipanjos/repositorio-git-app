package com.example.repositoriosgithub.domain

import com.example.repositoriosgithub.core.UseCase
import com.example.repositoriosgithub.data.model.Repo
import com.example.repositoriosgithub.data.repositories.RepoRepository
import kotlinx.coroutines.flow.Flow

class ListUserRepositoriesUseCase(private val repository: RepoRepository) :
    UseCase<String, List<Repo>>() {
    override suspend fun execute(param: String): Flow<List<Repo>> {
        return repository.listRepositories(param)
    }

}