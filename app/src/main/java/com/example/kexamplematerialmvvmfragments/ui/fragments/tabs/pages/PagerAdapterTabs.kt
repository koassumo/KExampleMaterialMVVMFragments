package com.example.kexamplematerialmvvmfragments.ui.fragments.tabs.pages

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


private const val BUTTON_ONE_PAGE = 0
private const val BUTTON_TWO_PAGE = 1
private const val BUTTON_THREE_PAGE = 2

class PagerAdapterTabs (private val fragmentManager: FragmentManager) : FragmentStatePagerAdapter (fragmentManager) {

//    FragmentStatePagerAdapter - постоянно помнит только 3 вкладки
//    FragmentPagerAdapter - постоянно помнит все вкладки (работает быстрее, но только если вкладок немного)
//    ?или наоборот


    private val fragments = arrayOf(TabPageOneFragment(), TabPageTwoFragment(), TabPageThreeFragment())

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> fragments[BUTTON_ONE_PAGE]
            1 -> fragments[BUTTON_TWO_PAGE]
            2 -> fragments[BUTTON_THREE_PAGE]
            else -> fragments[BUTTON_ONE_PAGE]
        }
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Tab One"
            1 -> "Tab Two"
            2 -> "Tab Three"
            else -> "Tab One"
        }
    }

}