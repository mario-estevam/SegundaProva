package com.mariobr.segundaprova.viewModels

import androidx.lifecycle.ViewModel
import com.mariobr.segundaprova.animes.Anime
import com.mariobr.segundaprova.fragments.bindingAltera

class AlteraViewModel:ViewModel() {
    var nome:String = ""
    var arcos:String = ""
    var eps:Int = 0
    var classificacao:Int = 0
    var nota:Double = 0.0
    var classificacao2:String = ""
    var nota2:String =""
    var eps2:String= ""
    var x = 0;
    lateinit var array:Array<Anime>

    fun set(){
        classificacao2 = classificacao.toString()
        nota2 = nota.toString()
        eps2 = eps.toString()
    }

    fun setAtributtes(){
        nome = array[x].nome
        arcos = array[x].arcos
        eps = array[x].eps
        classificacao = array[x].classificacao
        nota = array[x].nota
        set()
    }





}