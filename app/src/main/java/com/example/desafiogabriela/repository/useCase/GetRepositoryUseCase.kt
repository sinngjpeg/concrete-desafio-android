package com.example.desafiogabriela.repository.useCase

import com.example.desafiogabriela.api.GitHubAPIService
import com.example.desafiogabriela.model.Items
import com.example.desafiogabriela.repository.useCase.listener.RepositoryResultListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetRepositoryUseCase(
    private val apiService: GitHubAPIService,
) {

    suspend fun execute(page: Int): Items = withContext(Dispatchers.IO) {
        apiService.search(page)
    }
}
