package com.example.kexamplematerialmvvmfragments.ui.fragments.tabs

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kexamplematerialmvvmfragments.R
import com.example.kexamplematerialmvvmfragments.ui.fragments.buttons.pages.ViewPagerAdapter
import com.example.kexamplematerialmvvmfragments.ui.fragments.tabs.pages.PagerAdapterTabs
import kotlinx.android.synthetic.main.tabs_fixed_fragment.*


class TabsFixedFragment : Fragment() {

    companion object {
        fun newInstance() = TabsFixedFragment()
    }

    private lateinit var viewModel: TabsFixedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tabs_fixed_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view_pager_tabs.adapter = PagerAdapterTabs (childFragmentManager)
        tab_layout_tabs.setupWithViewPager(view_pager_tabs)

        tab_layout_tabs.getTabAt(0)?.setIcon(R.drawable.ic_archive)
        tab_layout_tabs.getTabAt(1)?.setIcon(R.drawable.ic_wikipedia)
        tab_layout_tabs.getTabAt(2)?.setIcon(R.drawable.ic_send)

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TabsFixedViewModel::class.java)
        // TODO: Use the ViewModel
    }

}