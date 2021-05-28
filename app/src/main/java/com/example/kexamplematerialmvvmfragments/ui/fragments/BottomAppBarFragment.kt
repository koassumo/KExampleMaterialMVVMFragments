package com.example.kexamplematerialmvvmfragments.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kexamplematerialmvvmfragments.R
import com.example.kexamplematerialmvvmfragments.viewmodel.BottomAppBarViewModel

class BottomAppBarFragment : Fragment() {

    companion object {
        fun newInstance() = BottomAppBarFragment()
    }

    private lateinit var viewModel: BottomAppBarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_app_bar_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BottomAppBarViewModel::class.java)
        // TODO: Use the ViewModel
    }

}