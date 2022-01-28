package com.mariobr.segundaprova.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.mariobr.segundaprova.animes.Anime
import com.mariobr.segundaprova.animes.AppDatabase

class HomeFragmentViewModel(application: Application) : AndroidViewModel(application)  {

    var listaAnimes : LiveData<List<Anime>>?= null

    init {
        val animeDAO = AppDatabase.getDatabase(application).animeDao()
         listaAnimes = animeDAO.listAll()
        }


    }

