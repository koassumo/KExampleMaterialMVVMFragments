package com.example.kexamplematerialmvvmfragments.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kexamplematerialmvvmfragments.R
import com.example.kexamplematerialmvvmfragments.ui.fragments.demobuttons.ViewPagerAdapter
import com.example.kexamplematerialmvvmfragments.viewmodel.ButtonsViewModel
import kotlinx.android.synthetic.main.buttons_fragment.*

class ButtonsFragment : Fragment() {

    companion object {
        fun newInstance() = ButtonsFragment()
    }

    private lateinit var viewModel: ButtonsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.buttons_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view_pager.adapter = ViewPagerAdapter(childFragmentManager)
        tab_layout.setupWithViewPager(view_pager)

        tab_layout.getTabAt(0)?.setIcon(R.drawable.ic_archive)
        tab_layout.getTabAt(1)?.setIcon(R.drawable.ic_hamburger_menu_bottom_bar)
        tab_layout.getTabAt(2)?.setIcon(R.drawable.ic_send)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ButtonsViewModel::class.java)

    }

}