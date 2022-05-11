package com.example.kexamplematerialmvvmfragments.ui.fragments.edittext

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kexamplematerialmvvmfragments.R

class TextFieldFragment : Fragment() {

    companion object {
        fun newInstance() = TextFieldFragment()
    }

    private lateinit var viewModel: TextFieldViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.text_field_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TextFieldViewModel::class.java)
        // TODO: Use the ViewModel
    }

}