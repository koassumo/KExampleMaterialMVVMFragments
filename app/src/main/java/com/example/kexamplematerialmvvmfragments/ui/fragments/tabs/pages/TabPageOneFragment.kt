package com.example.kexamplematerialmvvmfragments.ui.fragments.tabs.pages

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kexamplematerialmvvmfragments.R

class TabPageOneFragment : Fragment() {

    companion object {
        fun newInstance() = TabPageOneFragment()
    }

    private lateinit var viewModel: TabPageOneViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tab_page_one_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TabPageOneViewModel::class.java)
        // TODO: Use the ViewModel
    }

}