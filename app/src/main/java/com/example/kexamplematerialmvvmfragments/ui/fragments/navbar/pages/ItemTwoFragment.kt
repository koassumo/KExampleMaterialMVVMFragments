package com.example.kexamplematerialmvvmfragments.ui.fragments.navbar.pages

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kexamplematerialmvvmfragments.R

class ItemTwoFragment : Fragment() {

    companion object {
        fun newInstance() = ItemTwoFragment()
    }

    private lateinit var viewModel: ItemTwoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.item_two_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ItemTwoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}