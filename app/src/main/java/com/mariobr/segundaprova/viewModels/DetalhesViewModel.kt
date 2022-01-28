package com.mariobr.segundaprova.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.mariobr.segundaprova.animes.AppDatabase
import com.mariobr.segundaprova.fragments.bindingD

class DetalhesViewModel(application: Application) : AndroidViewModel(application)  {

    val animeDAO = AppDatabase.getDatabase(application).animeDao()

    fun find(id:Int){
        var encontrarAnime = animeDAO.findById(id)
        bindingD.editTextnome.text = encontrarAnime.nome
        bindingD.editTextTexteps.text = encontrarAnime.eps.toString()
        bindingD.editTextArcos.text = encontrarAnime.arcos
        bindingD.editTextAno.text = encontrarAnime.ano.toString()
        bindingD.editTextIdioma.text = encontrarAnime.idioma
        bindingD.editTextTextClassificacao.text = encontrarAnime.classificacao.toString()
    }


}