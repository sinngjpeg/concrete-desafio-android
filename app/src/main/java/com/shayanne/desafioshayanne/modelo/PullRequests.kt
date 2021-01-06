package com.shayanne.desafioshayanne.modelo

import com.google.gson.annotations.SerializedName

data class PullRequests(

    @SerializedName("title") val titulo_pull: String,
    @SerializedName("body") val descricao_pull: String,
    @SerializedName("user") val donoRep: DonoRep,
    @SerializedName("html_url") val urlpull : String,
    @SerializedName("full_name") val nome_completo_pull: String

)

