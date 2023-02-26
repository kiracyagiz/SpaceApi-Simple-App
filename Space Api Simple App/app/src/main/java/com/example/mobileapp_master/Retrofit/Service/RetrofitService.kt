package com.example.mobileapp_master.Retrofit.Service

import com.example.mobileapp_master.Data.Episode
import com.example.mobileapp_master.Data.Location
import com.example.mobileapp_master.Data.Character
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {



    @GET("character")
    fun getCharacter() : Call<ArrayList<Character>>


    @GET("episode")
    fun getEpisode(): Call<ArrayList<Episode>>


    @GET("location")
    fun getLocation(): Call<ArrayList<Location>>





}