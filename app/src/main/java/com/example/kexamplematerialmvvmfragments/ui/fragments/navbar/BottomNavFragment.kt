package com.example.kexamplematerialmvvmfragments.ui.fragments.navbar

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kexamplematerialmvvmfragments.R
import com.example.kexamplematerialmvvmfragments.ui.fragments.navbar.pages.ItemOneFragment
import com.example.kexamplematerialmvvmfragments.ui.fragments.navbar.pages.ItemThreeFragment
import com.example.kexamplematerialmvvmfragments.ui.fragments.navbar.pages.ItemTwoFragment
import kotlinx.android.synthetic.main.nav_bar_fragment.*

class BottomNavFragment : Fragment() {

    companion object {
        fun newInstance() = BottomNavFragment()
    }

    private lateinit var viewModel: NavBarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.nav_bar_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        childFragmentManager.beginTransaction()
            .replace(R.id.bottom_container, ItemOneFragment())
            .commitAllowingStateLoss()

        bottom_navigation_view.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_item_one -> {
                    childFragmentManager.beginTransaction()
                        .replace(R.id.bottom_container, ItemOneFragment())
                        .commitAllowingStateLoss()
                    true
                }
                R.id.bottom_item_two -> {
                    childFragmentManager.beginTransaction()
                        .replace(R.id.bottom_container, ItemTwoFragment())
                        .commitAllowingStateLoss()
                    true
                }
                R.id.bottom_item_three -> {
                    childFragmentManager.beginTransaction()
                        .replace(R.id.bottom_container, ItemThreeFragment())
                        .commitAllowingStateLoss()
                    true
                }
                else -> {
                    childFragmentManager.beginTransaction()
                        .replace(R.id.bottom_container, ItemOneFragment())
                        .commitAllowingStateLoss()
                    true
                }
            }
        }
    }



}