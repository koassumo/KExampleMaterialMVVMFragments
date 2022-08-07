package com.example.kexamplematerialmvvmfragments.ui.fragments.buttons.pages

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kexamplematerialmvvmfragments.R

class ButtonThreeFragment : Fragment() {

    companion object {
        fun newInstance() = ButtonThreeFragment()
    }

    //private lateinit var viewModel: ButtonThreeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.button_three_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(ButtonThreeViewModel::class.java)
    }

}