package com.mariobr.segundaprova.viewModels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mariobr.segundaprova.animes.Anime
import com.mariobr.segundaprova.animes.AppDatabase


class AlteraViewModel(application: Application) : AndroidViewModel(application) {

    val animeDAO = AppDatabase.getDatabase(application).animeDao()

    var animeId = MutableLiveData<Int>(null)
    var nome = MutableLiveData<String>()
    var arcos = MutableLiveData<String>()
    var eps  = MutableLiveData(0)
    var ano = MutableLiveData<Int>(0)
    var idiomas  = MutableLiveData<String>()
    var classificacao = MutableLiveData(0)



    var anime: Anime
        get() {
            val animeReturn = Anime(
                nome.value!!,
                arcos.value!!,
                eps.value!!,
                ano.value!!,
                idiomas.value!!,
                classificacao.value!!
            )
            animeReturn.id = animeId.value!!
            return animeReturn
        }
        set(anime) {
            animeId.value = anime.id
            nome.value = anime.nome
            arcos.value =anime.arcos
            eps.value = anime.eps
            ano.value = anime.ano
            idiomas.value = anime.idioma
            classificacao.value = anime.classificacao
        }

    fun findByid(id:Int){
        val animeEncontrado = animeDAO.findById(id)
        anime = animeEncontrado
    }

    fun saveAnime() {
        animeDAO.atualizar(anime)
    }



}
