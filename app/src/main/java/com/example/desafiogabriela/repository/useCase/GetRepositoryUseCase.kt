package com.example.desafiogabriela.repository.useCase

import com.example.desafiogabriela.api.GitHubAPIService
import com.example.desafiogabriela.domain.model.Items
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetRepositoryUseCase(
    private val apiService: GitHubAPIService,
) {

    suspend fun execute(page: Int): Items = withContext(Dispatchers.IO) {
        apiService.search(page)
    }
}
