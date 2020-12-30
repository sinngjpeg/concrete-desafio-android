package com.shayanne.desafioshayanne.modelo

import com.google.gson.annotations.SerializedName

data class PullRequests(

        @SerializedName("title") val titulo_pull: String,
        @SerializedName("body") val descricao_pull: String,
       // @SerializedName("name") val user_pull: Int,
        @SerializedName("user") val donoRep: DonoRep,
       /* @SerializedName("owner") val donoRep: DonoRep,
        @SerializedName("user") val donoPicture: DonoRep,*/
       @SerializedName("full_name") val nome_completo_pull: String

)
