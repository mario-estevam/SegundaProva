package com.mariobr.segundaprova.newViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mariobr.segundaprova.animes.Anime
import com.mariobr.segundaprova.animes.AppDatabase
import com.mariobr.segundaprova.repositories.AnimeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelAnimeCadastro(application: Application) : AndroidViewModel(application) {

    val listAll:LiveData<List<Anime>>
    private val repository: AnimeRepository
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


    init{
        val animeDAO = AppDatabase.getDatabase(application).animeDao()
        repository = AnimeRepository(animeDAO)
        listAll = repository.animeList
    }


    fun addAnime(){
        viewModelScope.launch ( Dispatchers.IO ){
            repository.insert(anime)
        }
    }




}
