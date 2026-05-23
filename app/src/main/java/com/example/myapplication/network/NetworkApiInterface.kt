package com.example.myapplication.network

import com.example.myapplication.network.model.ResponseData
import com.example.myapplication.network.model.Result
import retrofit2.Call
import retrofit2.http.GET

interface NetworkApiInterface {


    @GET("/todos")
    fun getUsers(): Call<List<Result>>
}