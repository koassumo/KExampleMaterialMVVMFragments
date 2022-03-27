package com.example.kexamplematerialmvvmfragments.ui.fragments.animation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kexamplematerialmvvmfragments.R

class AnimationFiveFragment : Fragment() {

    companion object {
        fun newInstance() = AnimationFiveFragment()
    }

    private lateinit var viewModel: AnimationFiveViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.animation_five_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AnimationFiveViewModel::class.java)
        // TODO: Use the ViewModel
    }

}