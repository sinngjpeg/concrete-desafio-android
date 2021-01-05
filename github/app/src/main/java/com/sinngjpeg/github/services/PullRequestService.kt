package com.sinngjpeg.github.services

import com.sinngjpeg.github.model.PullRequest
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PullRequestService {

    @GET("repos/{owner}/{repo}/pulls")
    fun getPullRequest(
        @Path("owner") creator: String,
        @Path("repo") repository: String
    ): Call<List<PullRequest>>


}