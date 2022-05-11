package com.example.kexamplematerialmvvmfragments.ui.fragments.navbar.pages

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kexamplematerialmvvmfragments.R

class ItemThreeFragment : Fragment() {

    companion object {
        fun newInstance() = ItemThreeFragment()
    }

    private lateinit var viewModel: ItemThreeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.item_three_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ItemThreeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}