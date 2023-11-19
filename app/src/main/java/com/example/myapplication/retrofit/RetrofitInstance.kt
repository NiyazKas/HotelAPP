package com.example.myapplication.retrofit

import com.example.myapplication.Const
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val retrofit = Retrofit.Builder()
        .baseUrl(Const.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}