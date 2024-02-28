package com.example.kexamplematerialmvvmfragments.ui.fragments.buttons

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kexamplematerialmvvmfragments.R
import com.example.kexamplematerialmvvmfragments.databinding.ButtonsFragmentBinding
import com.example.kexamplematerialmvvmfragments.ui.fragments.buttons.pages.ViewPagerAdapter

class ButtonsFragment : Fragment() {

    private var _binding: ButtonsFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = ButtonsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = ViewPagerAdapter(childFragmentManager)
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        binding.tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_button_square_single_24)
        binding.tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_button_grid_multi_24)
        binding.tabLayout.getTabAt(2)?.setIcon(R.drawable.ic_button_circle_floating_24)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
