package com.example.kexamplematerialmvvmfragments.ui.fragmentsettings

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kexamplematerialmvvmfragments.R
import com.example.kexamplematerialmvvmfragments.viewmodel.TypographyViewModel

class TypographyFragment : Fragment() {

    companion object {
        fun newInstance() = TypographyFragment()
    }

    private lateinit var viewModel: TypographyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.typography_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TypographyViewModel::class.java)
        // TODO: Use the ViewModel
    }

}