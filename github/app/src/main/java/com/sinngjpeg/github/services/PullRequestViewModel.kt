package com.sinngjpeg.github.services

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sinngjpeg.github.model.PullRequest
import com.sinngjpeg.github.model.Repository

class PullRequestViewModel : ViewModel() {

    val pullRequestLiveData: MutableLiveData<List<PullRequest>> = MutableLiveData()

    fun getPullRepository() {
        pullRequestLiveData.value = createFakePullRequest()
    }

    fun createFakePullRequest(): List<PullRequest> {
        return listOf<PullRequest>(
            PullRequest("nome1", "descricao1", "", "username1", "full name1")
        )
    }
}