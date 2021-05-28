package com.example.kexamplematerialmvvmfragments.ui.fragments.demobuttons

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kexamplematerialmvvmfragments.R
import com.example.kexamplematerialmvvmfragments.viewmodel.demobuttons.ButtonThreeViewModel

class ButtonThreeFragment : Fragment() {

    companion object {
        fun newInstance() = ButtonThreeFragment()
    }

    private lateinit var viewModel: ButtonThreeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.button_three_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ButtonThreeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}