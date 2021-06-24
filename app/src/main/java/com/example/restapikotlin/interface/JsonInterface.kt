package com.example.restapikotlin.`interface`

import com.example.restapikotlin.model.model
import retrofit2.Call
import retrofit2.http.GET

interface JsonInterface {

    @GET(value = "posts")

    fun getInfo(): Call<List<model>>

}