package com.sinngjpeg.github.activities

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sinngjpeg.github.model.Repository

class RepositoryViewModel : ViewModel() {

    val repositoryLiveData: MutableLiveData<List<Repository>> = MutableLiveData()

    fun getRepository() {
        repositoryLiveData.value = createFakeRepositories()
    }

    fun createFakeRepositories(): List<Repository> {
        return listOf<Repository>(
            Repository(
                "Repositorio 1", "Descricao repositorio1", "",
                1234, "", 31232, "", "username1", "full name 1"
            ),
            Repository(
                "Repositorio 2", "Descricao repositorio1", "",
                1234, "", 31232, "", "username1", "full name 1"
            ),
            Repository(
                "Repositorio 3", "Descricao repositorio1", "",
                1234, "", 31232, "", "username1", "full name 1"
            )
        )
    }

}