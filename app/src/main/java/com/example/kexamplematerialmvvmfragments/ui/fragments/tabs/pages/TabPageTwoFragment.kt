package com.example.kexamplematerialmvvmfragments.ui.fragments.tabs.pages

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kexamplematerialmvvmfragments.R

class TabPageTwoFragment : Fragment() {

    companion object {
        fun newInstance() = TabPageTwoFragment()
    }

    private lateinit var viewModel: TabPageTwoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tab_page_two_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TabPageTwoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}