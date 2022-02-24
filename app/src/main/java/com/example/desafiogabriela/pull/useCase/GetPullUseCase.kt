package com.example.desafiogabriela.pull.useCase

import com.example.desafiogabriela.api.GitHubAPIService
import com.example.desafiogabriela.model.ItemPullrequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetPullUseCase(
    private val apiService: GitHubAPIService,
) {
    suspend fun execute(
        owner: String, repository: String,
    ): List<ItemPullrequest> = withContext(Dispatchers.IO) {
        apiService.searchPull(owner, repository)
    }
}