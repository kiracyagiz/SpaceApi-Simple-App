package com.example.mobileapp_master.Retrofit

import com.example.mobileapp_master.Retrofit.Service.RetrofitService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

 object RetrofitInstance {

    const val BASE_URL = "https://finalspaceapi.com/api/v0/"

    val retrofit : Retrofit =
        Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val AppApi = retrofit.create<RetrofitService>()


}