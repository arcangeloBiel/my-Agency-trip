package com.agencytravelboat.amazon.presentation.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.agencytravelboat.amazon.data.model.Embarcacao
import com.agencytravelboat.amazon.data.repository.EmbarcacaoRepository
import com.google.gson.Gson

class HomeViewModel : ViewModel() {

    private val repository = EmbarcacaoRepository()

    private val _newsFeedLiveData = MutableLiveData<List<Embarcacao>>()
    val newsFeedLiveData: LiveData<List<Embarcacao>>
    get()= _newsFeedLiveData

    @SuppressLint("SuspiciousIndentation")
    fun fetchNewsFeed() {
     var result =  repository.fetchVessels(_newsFeedLiveData)
       // _newsFeedLiveData.postValue((result )
        val gson = Gson()
        Log.d("resultado", "lista filtro ${gson.toJson(result) }")
    }

}