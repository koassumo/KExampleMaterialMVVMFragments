package com.example.kexamplematerialmvvmfragments.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kexamplematerialmvvmfragments.R
import com.example.kexamplematerialmvvmfragments.viewmodel.EditTextViewModel

class EditTextFragment : Fragment() {

    companion object {
        fun newInstance() = EditTextFragment()
    }

    private lateinit var viewModel: EditTextViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.edit_text_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EditTextViewModel::class.java)
        // TODO: Use the ViewModel
    }

}