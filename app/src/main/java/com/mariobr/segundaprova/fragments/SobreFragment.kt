package com.mariobr.segundaprova.fragments

import SobreViewModel
import SobreViewModelFactory
import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.mariobr.segundaprova.R


class SobreFragment : Fragment() {
    lateinit var viewModel:SobreViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val viewModelFactory = SobreViewModelFactory(requireContext())
        viewModel = ViewModelProvider(this, viewModelFactory).get(SobreViewModel::class.java)


        return inflater.inflate(R.layout.fragment_sobre, container, false)
    }

}