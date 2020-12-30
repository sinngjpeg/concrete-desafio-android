package com.shayanne.desafioshayanne.modelo

import com.google.gson.annotations.SerializedName

data class Repository(
        @SerializedName("name") val nome_repositorio: String,
        @SerializedName("description") val descricao_rep: String,
        // @SerializedName("avatar_url") val user_rep: Int,
        @SerializedName("owner") val donoRep: DonoRep,
        @SerializedName("full_name") val nome_completo_rep: String,
        // val fork: Int,
        @SerializedName("forks_count") var n_conexoes: Int,
        //val  estrela: Int,
        @SerializedName("stargazers_count") var n_estrelas: Int
)

