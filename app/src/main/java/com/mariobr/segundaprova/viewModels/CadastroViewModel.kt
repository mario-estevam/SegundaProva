package com.mariobr.segundaprova.viewModels

import androidx.lifecycle.ViewModel
import com.mariobr.segundaprova.fragments.bindingCadastro

class CadastroViewModel: ViewModel() {
    var nome:String = ""
    var arcos:String = ""
    var eps:Int = 0
    var classificacao:Int = 0
    var nota:Double = 0.0
    
    fun setAtrributes(){
        nome = bindingCadastro.editTextnome.text.toString()
        arcos = bindingCadastro.editTextArcos.text.toString()
        eps = bindingCadastro.editTextTexteps.text.toString().toInt()
        nota = bindingCadastro.ratingBar.rating.toDouble()
        classificacao = bindingCadastro.editTextTextClassificacao.text.toString().toInt()
    }


}