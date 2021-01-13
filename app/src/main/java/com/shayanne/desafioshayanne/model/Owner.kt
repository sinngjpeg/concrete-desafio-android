package com.shayanne.desafioshayanne.model

import com.google.gson.annotations.SerializedName

data class Owner (

    @SerializedName("login") val username_rep: String,
    @SerializedName("avatar_url") val user_rep : String

)

