package com.example.kexamplematerialmvvmfragments.ui.fragments.tabs

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kexamplematerialmvvmfragments.R
import com.example.kexamplematerialmvvmfragments.databinding.TabsFixedFragmentBinding
import com.example.kexamplematerialmvvmfragments.ui.fragments.tabs.pages.PagerAdapterTabs

class TabsFixedFragment : Fragment() {

    private var _binding: TabsFixedFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = TabsFixedFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPagerTabs.adapter = PagerAdapterTabs(childFragmentManager)
        binding.tabLayoutTabs.setupWithViewPager(binding.viewPagerTabs)

        binding.tabLayoutTabs.getTabAt(0)?.setIcon(R.drawable.ic_archive)
        binding.tabLayoutTabs.getTabAt(1)?.setIcon(R.drawable.ic_wikipedia)
        binding.tabLayoutTabs.getTabAt(2)?.setIcon(R.drawable.ic_send)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
