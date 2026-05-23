package com.example.myapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NetworkApi {
    companion object{
        private var  retrofit: Retrofit?=null

        fun getRetrofitInstance(): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }

        fun getApiInterface(): NetworkApiInterface {
            return getRetrofitInstance().create<NetworkApiInterface?>(NetworkApiInterface::class.java)
        }
    }

}