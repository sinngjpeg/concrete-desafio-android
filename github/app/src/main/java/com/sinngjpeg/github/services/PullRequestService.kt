package com.sinngjpeg.github.services

import com.sinngjpeg.github.model.PullRequest
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PullRequestService : Call<PullRequest> {

    @GET("repos/{creator}/{repository}/pulls")
    fun getPullRequest(
        @Path("creator") creator:String,
        @Path("repository") repositorie:String
    ): Call<List<PullRequest>>


}