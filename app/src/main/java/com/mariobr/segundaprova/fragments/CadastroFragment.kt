package com.mariobr.segundaprova.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.mariobr.segundaprova.dialogs.CustomDialogFragment
import com.mariobr.segundaprova.R
import com.mariobr.segundaprova.databinding.FragmentCadastroBinding
import com.mariobr.segundaprova.viewModels.ViewModelCadastro


lateinit var bindingCadastro:FragmentCadastroBinding

@SuppressLint("UseRequireInsteadOfGet")
class CadastroFragment : Fragment() {
    lateinit var viewModel: ViewModelCadastro
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        bindingCadastro= DataBindingUtil.inflate(inflater, R.layout.fragment_cadastro, container, false)
        viewModel = ViewModelProvider(this).get(ViewModelCadastro::class.java)

        bindingCadastro.viewModel = viewModel
        bindingCadastro.cadastrar.setOnClickListener {
            viewModel.salvarAnime()
            Navigation.findNavController(it).navigate(R.id.homeFragment)
            Toast.makeText(context, "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
        }
        setHasOptionsMenu(true)
        return bindingCadastro.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.saiba -> {
                val dialog = CustomDialogFragment()
                dialog.show(requireActivity().supportFragmentManager,"Dialog2")
            }
        }
        return super.onOptionsItemSelected(item)
    }

}