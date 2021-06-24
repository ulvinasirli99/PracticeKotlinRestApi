package com.example.restapikotlin.model

import com.google.gson.annotations.SerializedName

class model (

    val id:Int,

    val title:String,

    @SerializedName(value = "body")

    val mBody:String

)