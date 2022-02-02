package com.mariobr.segundaprova.viewModels

import android.app.Application
import android.content.Context

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mariobr.segundaprova.animes.Anime
import com.mariobr.segundaprova.animes.AppDatabase


class ViewModelCadastro(application: Application) : AndroidViewModel(application)  {

    val db = AppDatabase.getDatabase(application).animeDao()

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
        db.inserir(anime)
    }

}