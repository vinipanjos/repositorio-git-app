package com.example.repositoriosgithub.data.repositories

import com.example.repositoriosgithub.core.RemoteException
import com.example.repositoriosgithub.data.services.GitHubService
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class RepoRepositoriesImpl(private val service: GitHubService) : RepoRepository{
    override suspend fun listRepositories(user: String) = flow {
        try {

        } catch (ex: HttpException){
            throw RemoteException(ex.message() ?: "Não foi possivel fazer a busca no momento!")
        }
        val repoList = service.listRepositories(user)
        emit(repoList)
    }
}