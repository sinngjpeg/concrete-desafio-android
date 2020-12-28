package com.sinngjpeg.github.services

import com.sinngjpeg.github.model.PullRequestModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PullRequestService : Call<PullRequestModel> {

    @GET("repos/{creator}/{repository}/pulls")
    fun getPullRequest(
        @Path("creator") creator:String,
        @Path("repository") repositorie:String
    ): Call<List<PullRequestModel>>


}