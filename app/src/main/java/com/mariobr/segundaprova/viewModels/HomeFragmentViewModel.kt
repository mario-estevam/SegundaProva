package com.mariobr.segundaprova.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.mariobr.segundaprova.animes.Anime
import com.mariobr.segundaprova.animes.AppDatabase

class HomeFragmentViewModel(application: Application) : AndroidViewModel(application)  {

    var listaAnimes : LiveData<List<Anime>>?= null

    init {
        val db: AppDatabase by lazy{
            Room.databaseBuilder(
                application,
                AppDatabase::class.java, "database-name")
                .allowMainThreadQueries()
                .build()
        }
        listaAnimes = db.animeDao().listAll()
    }

}