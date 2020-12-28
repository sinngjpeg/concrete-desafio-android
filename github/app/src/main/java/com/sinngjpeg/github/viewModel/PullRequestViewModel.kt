package com.sinngjpeg.github.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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