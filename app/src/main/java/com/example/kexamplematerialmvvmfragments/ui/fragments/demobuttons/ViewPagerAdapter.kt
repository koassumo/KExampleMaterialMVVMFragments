package com.example.kexamplematerialmvvmfragments.ui.fragments.demobuttons

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

private const val BUTTON_ONE_FRAGMENT = 0
private const val BUTTON_TWO_FRAGMENT = 1
private const val BUTTON_THREE_FRAGMENT = 2

class ViewPagerAdapter(private val fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {

//    FragmentStatePagerAdapter - постоянно помнит только 3 вкладки
//    FragmentPagerAdapter - постоянно помнит все вкладки (работает быстрее, но только если вкладом немного)
//    ?или наоборот


    private val fragments = arrayOf(ButtonOneFragment(), ButtonTwoFragment(), ButtonThreeFragment())

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> fragments[BUTTON_ONE_FRAGMENT]
            1 -> fragments[BUTTON_TWO_FRAGMENT]
            2 -> fragments[BUTTON_THREE_FRAGMENT]
            else -> fragments[BUTTON_ONE_FRAGMENT]
        }
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Text buttons"
            1 -> "Toggle buttons"
            2 -> "Gradient buttons"
            else -> "Text buttons"
        }
    }
}