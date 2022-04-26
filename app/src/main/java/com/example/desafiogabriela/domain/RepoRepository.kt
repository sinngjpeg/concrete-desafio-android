package com.example.desafiogabriela.domain

import com.example.desafiogabriela.domain.model.ItemRepository

interface RepoRepository {
    suspend fun getRepository(
        page: Int
    ) : ItemRepository
}