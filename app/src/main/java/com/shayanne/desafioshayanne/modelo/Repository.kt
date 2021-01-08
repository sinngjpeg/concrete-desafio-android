package com.shayanne.desafioshayanne.modelo

import com.google.gson.annotations.SerializedName

data class Repository(
        @SerializedName("name") val nome_repositorio: String,
        @SerializedName("description") val descricao_rep: String,
        @SerializedName("owner") val donoRep: DonoRep,
        @SerializedName("full_name") val nome_completo_rep: String,
        @SerializedName("forks_count") var n_conexoes: Int,
        @SerializedName("stargazers_count") var n_estrelas: Int
)

