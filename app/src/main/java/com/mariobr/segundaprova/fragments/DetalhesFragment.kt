package com.mariobr.segundaprova.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.room.Room
import com.mariobr.segundaprova.R
import com.mariobr.segundaprova.animes.AppDatabase
import com.mariobr.segundaprova.databinding.FragmentDetalhesBinding
import com.mariobr.segundaprova.dialogs.DialogDetalhes
import com.mariobr.segundaprova.dialogs.DialogHome
import com.mariobr.segundaprova.viewModels.DetalhesViewModel
import com.mariobr.segundaprova.viewModels.HomeFragmentViewModel


lateinit var bindingD:FragmentDetalhesBinding

@SuppressLint("UseRequireInsteadOfGet")
class DetalhesFragment : Fragment() {


    lateinit var viewModelD: DetalhesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingD= DataBindingUtil.inflate(inflater, R.layout.fragment_detalhes, container, false)
        viewModelD = ViewModelProvider(this).get(DetalhesViewModel::class.java)
        // Inflate the layout for this fragment
        val args:DetalhesFragmentArgs by navArgs()
        val x = args.id
        viewModelD.find(x.toInt())
        setHasOptionsMenu(true)
        return bindingD.root
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.saiba -> {
                val dialog = DialogDetalhes()
                dialog.show(requireActivity().supportFragmentManager,"Dialog4")
            }
        }
        return super.onOptionsItemSelected(item)
    }

}