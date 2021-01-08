package com.shayanne.desafioshayanne.modelo

import com.google.gson.annotations.SerializedName

data class DonoRep (

    @SerializedName("login") val username_rep: String,
    @SerializedName("avatar_url") val user_rep : String

)

