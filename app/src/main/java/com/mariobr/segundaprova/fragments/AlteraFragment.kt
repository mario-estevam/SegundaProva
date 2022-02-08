package com.mariobr.segundaprova.fragments

import com.mariobr.segundaprova.viewModels.AlteraViewModel
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
import androidx.navigation.fragment.navArgs
import com.mariobr.segundaprova.R
import com.mariobr.segundaprova.databinding.FragmentAlteraBinding
import com.mariobr.segundaprova.dialogs.DialogAlterar
import com.mariobr.segundaprova.viewModels.DetalhesViewModel



@SuppressLint("UseRequireInsteadOfGet")
class AlteraFragment : Fragment() {

    lateinit var bindingAltera:FragmentAlteraBinding
    lateinit var viewModelAltera: AlteraViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args:AlteraFragmentArgs by navArgs()

        bindingAltera= DataBindingUtil.inflate(inflater, R.layout.fragment_altera, container, false)
        val viewModelFactory = AlteraViewModel.AlteraFragmentViewModelFactory(requireActivity().application,
            args.id.toInt()
        )
        viewModelAltera = ViewModelProvider(this,viewModelFactory).get(AlteraViewModel::class.java)

        bindingAltera.alteraViewModel = viewModelAltera
        bindingAltera.lifecycleOwner = this

        bindingAltera.alterar.setOnClickListener {
            viewModelAltera .saveAnime()
            Navigation.findNavController(it).navigate(R.id.homeFragment)
            Toast.makeText(context, "Dados alterados com sucesso!", Toast.LENGTH_SHORT).show()
        }

        setHasOptionsMenu(true)
        return bindingAltera.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.saiba -> {
                val dialog = DialogAlterar()
                dialog.show(requireActivity().supportFragmentManager,"Dialog7")
            }
        }
        return super.onOptionsItemSelected(item)
    }

}