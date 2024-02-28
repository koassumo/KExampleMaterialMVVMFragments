package com.example.kexamplematerialmvvmfragments.ui.fragments.buttons.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kexamplematerialmvvmfragments.databinding.ButtonOneFragmentBinding

class ButtonOneFragment : Fragment() {

    private var _binding: ButtonOneFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = ButtonOneFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Здесь можно использовать binding для доступа к элементам UI, например, binding.btn1
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
