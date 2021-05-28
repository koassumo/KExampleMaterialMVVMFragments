package com.example.kexamplematerialmvvmfragments.ui.fragments.demobuttons

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kexamplematerialmvvmfragments.R
import com.example.kexamplematerialmvvmfragments.viewmodel.demobuttons.ButtonTwoViewModel

class ButtonTwoFragment : Fragment() {

    companion object {
        fun newInstance() = ButtonTwoFragment()
    }

    private lateinit var viewModel: ButtonTwoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.button_two_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ButtonTwoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}