package com.example.kexamplematerialmvvmfragments.ui.fragments.navbar.pages

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kexamplematerialmvvmfragments.R

class ItemOneFragment : Fragment() {

    companion object {
        fun newInstance() = ItemOneFragment()
    }

    private lateinit var viewModel: ItemOneViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.item_one_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ItemOneViewModel::class.java)
        // TODO: Use the ViewModel
    }

}