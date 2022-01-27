package com.mariobr.segundaprova.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.mariobr.segundaprova.R
import com.mariobr.segundaprova.databinding.FragmentCadastroBinding
import com.mariobr.segundaprova.viewModels.AlteraViewModelFactory
import com.mariobr.segundaprova.viewModels.ViewModelCadastro
import com.mariobr.segundaprova.viewModels.ViewModelCadastroFactory

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
        val viewModelFactory = ViewModelCadastroFactory(requireContext())
        viewModel = ViewModelProvider(this, viewModelFactory).get(ViewModelCadastro::class.java)

        bindingCadastro.viewModel = viewModelFactory

        bindingCadastro.cadastrar.setOnClickListener {
            viewModelFactory.salvarAnime()
            Navigation.findNavController(it).navigate(R.id.homeFragment)
            Toast.makeText(context, "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
        }
        setHasOptionsMenu(true)
        return bindingCadastro.root
    }

}