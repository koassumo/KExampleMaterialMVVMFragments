package com.example.kexamplematerialmvvmfragments.ui.fragments.tabs

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kexamplematerialmvvmfragments.R

class TabsScrolledFragment : Fragment() {

    companion object {
        fun newInstance() = TabsScrolledFragment()
    }

    private lateinit var viewModel: TabsScrolledViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tabs_scrolled_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TabsScrolledViewModel::class.java)
        // TODO: Use the ViewModel
    }

}