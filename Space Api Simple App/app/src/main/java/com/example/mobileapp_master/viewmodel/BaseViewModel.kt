package com.example.mobileapp_master.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mobileapp_master.Data.Episode
import com.example.mobileapp_master.Data.Location
import com.example.mobileapp_master.Data.Character
import com.example.mobileapp_master.Repository.PostRepo

class BaseViewModel  : ViewModel(){

    private var mainRepo = PostRepo()

    private var _character = MutableLiveData<ArrayList<Character>>()
    val character : LiveData<ArrayList<Character>>
        get() = _character

    private var _location = MutableLiveData<ArrayList<Location>>()
    val location : LiveData<ArrayList<Location>>
    get() = _location

    private var _episode = MutableLiveData<ArrayList<Episode>>()
    val episode : LiveData<ArrayList<Episode>>
    get() = _episode

    init {
        getCharacters()
        getLocations()
        getEpisodes()
        _character = mainRepo.characterList
        _location = mainRepo.locationList
        _episode = mainRepo.episodeList
    }


    private fun getCharacters() = mainRepo.characters()
    private fun getLocations() = mainRepo.locations()
    private fun getEpisodes() = mainRepo.episodes()


}