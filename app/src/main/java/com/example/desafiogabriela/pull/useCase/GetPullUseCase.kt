package com.example.desafiogabriela.pull.useCase

import com.example.desafiogabriela.api.GitHubAPIService
import com.example.desafiogabriela.model.ItemPullrequest
import com.example.desafiogabriela.model.Items
import com.example.desafiogabriela.pull.useCase.listener.PullResultListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetPullUseCase(
    private val apiService: GitHubAPIService,
) {
    suspend fun execute(
        owner: String, repository: String,
    ): List<ItemPullrequest> = withContext(Dispatchers.IO) {
        apiService.searchPull(owner, repository)
    }
}