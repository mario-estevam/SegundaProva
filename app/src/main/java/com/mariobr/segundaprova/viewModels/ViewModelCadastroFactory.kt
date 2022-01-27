package com.mariobr.segundaprova.viewModels

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.mariobr.segundaprova.animes.Anime
import com.mariobr.segundaprova.animes.AppDatabase

class ViewModelCadastroFactory(val context: Context) : ViewModelProvider.Factory  {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelCadastro::class.java)) {
            return ViewModelCadastro(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

    val db: AppDatabase by lazy{
        Room.databaseBuilder(
            context!!,
            AppDatabase::class.java, "database-name")
            .allowMainThreadQueries()
            .build()
    }

    var nome = MutableLiveData<String>()
    var arcos = MutableLiveData<String>()
    var eps  = MutableLiveData(0)
    var ano = MutableLiveData<Int>(0)
    var idiomas  = MutableLiveData<String>()
    var classificacao = MutableLiveData(0)

    val anime: Anime
        get() = Anime(
            nome.value!!,
            arcos.value!!,
            eps.value!!,
            ano.value!!,
            idiomas.value!!,
            classificacao.value!!
        )

    fun salvarAnime() {
       db.animeDao().inserir(anime)
    }


}