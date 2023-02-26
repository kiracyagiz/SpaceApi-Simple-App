package com.example.mobileapp_master.Repository

import androidx.lifecycle.MutableLiveData
import com.example.mobileapp_master.Retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.mobileapp_master.Data.Character
import com.example.mobileapp_master.Data.Episode
import com.example.mobileapp_master.Data.Location


class PostRepo()  {


    private val postService = RetrofitInstance.AppApi

    var characterList = MutableLiveData<ArrayList<Character>>()
    var locationList = MutableLiveData<ArrayList<Location>>()
    var episodeList = MutableLiveData<ArrayList<Episode>>()


    fun characters(){

        postService.getCharacter().enqueue(object: Callback<ArrayList<Character>>{
            override fun onResponse(call: Call<ArrayList<Character>>, response: Response<ArrayList<Character>>){

                if (response.isSuccessful){
                    characterList.value = response?.body()
                }

            }

            override fun onFailure(call: Call<ArrayList<Character>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }

    fun locations(){


        postService.getLocation().enqueue(object: Callback<ArrayList<Location>>{
            override fun onResponse(call: Call<ArrayList<Location>>, response: Response<ArrayList<Location>>)
            {
                locationList.value = response?.body()


            }

            override fun onFailure(call: Call<ArrayList<Location>>, t: Throwable) {
            }
        })
    }


    fun episodes(){
        postService.getEpisode().enqueue(object: Callback<ArrayList<Episode>>{
            override fun onResponse(call: Call<ArrayList<Episode>>, response: Response<ArrayList<Episode>>)
            {
                episodeList.value = response?.body()
            }

            override fun onFailure(call: Call<ArrayList<Episode>>, t: Throwable) {
            }

        })
    }



}