package com.mariobr.segundaprova.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.mariobr.segundaprova.R
import com.mariobr.segundaprova.databinding.FragmentDetalhesBinding
import com.mariobr.segundaprova.dialogs.DialogDetalhes
import com.mariobr.segundaprova.viewModels.DetalhesViewModel





@SuppressLint("UseRequireInsteadOfGet")
class DetalhesFragment : Fragment() {

    lateinit var bindingD:FragmentDetalhesBinding
    lateinit var viewModelD: DetalhesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args:DetalhesFragmentArgs by navArgs()
        val x = args.id.toInt()
        bindingD= DataBindingUtil.inflate(inflater, R.layout.fragment_detalhes, container, false)
        val viewModelFactory = DetalhesViewModel.DetalhesFragmentViewModelFactory(requireActivity().application, x)
        viewModelD = ViewModelProvider(this, viewModelFactory).get(DetalhesViewModel::class.java)

        bindingD.viewModelD = viewModelD
        bindingD.lifecycleOwner = this

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