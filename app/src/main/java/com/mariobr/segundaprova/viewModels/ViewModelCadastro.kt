package com.mariobr.segundaprova.viewModels

import android.app.Application
import android.content.Context

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mariobr.segundaprova.animes.Anime
import com.mariobr.segundaprova.animes.AppDatabase
import kotlinx.coroutines.launch


class ViewModelCadastro(application: Application) : AndroidViewModel(application)  {

    var anime = Anime()
    val db = AppDatabase.getDatabase(application).animeDao()

    fun cadastraAnime(){
        viewModelScope.launch {
            db.inserir(anime)
        }
    }

}