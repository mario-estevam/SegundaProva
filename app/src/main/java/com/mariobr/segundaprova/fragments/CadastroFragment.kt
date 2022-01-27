package com.mariobr.segundaprova.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.mariobr.segundaprova.R
import com.mariobr.segundaprova.databinding.FragmentCadastroBinding
import com.mariobr.segundaprova.viewModels.ViewModelCadastro

lateinit var bindingCadastro:FragmentCadastroBinding

@SuppressLint("UseRequireInsteadOfGet")
class CadastroFragment : Fragment() {
    lateinit var viewModel:ViewModelCadastro

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingCadastro= DataBindingUtil.inflate(inflater, R.layout.fragment_cadastro, container, false)
        viewModel = ViewModelProvider(this,).get(ViewModelCadastro::class.java)
        bindingCadastro.viewModelCadastro = viewModel
        bindingCadastro.cadastrar.setOnClickListener {
          viewModel.salvarAnime()
        }
        setHasOptionsMenu(true)
        return bindingCadastro.root
    }

}