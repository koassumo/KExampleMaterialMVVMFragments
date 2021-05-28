package com.example.kexamplematerialmvvmfragments.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kexamplematerialmvvmfragments.R
import com.example.kexamplematerialmvvmfragments.ui.fragments.*
import com.example.kexamplematerialmvvmfragments.ui.fragments.demorv.RVFragment
import com.example.kexamplematerialmvvmfragments.ui.fragmentsettings.ThemesFragment
import com.example.kexamplematerialmvvmfragments.ui.fragmentsettings.TypographyFragment
import com.example.kexamplematerialmvvmfragments.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

        btnFragmentEditText.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, EditTextFragment())?.addToBackStack(null)?.commit()
        }

        btnFragmentBottomSheet.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, BottomSheetFragment())?.addToBackStack(null)?.commit()
        }

        btnFragmentBottomAppBar.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, BottomAppBarFragment())?.addToBackStack(null)?.commit()
        }

        btnFragmentChips.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, ChipsFragment())?.addToBackStack(null)?.commit()
        }

        btnFragmentThemes.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, ThemesFragment())?.addToBackStack(null)?.commit()
        }

        btnFragmentTypography.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, TypographyFragment())?.addToBackStack(null)?.commit()
        }

        btnFragmentButtons.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, ButtonsFragment())?.addToBackStack(null)?.commit()
        }

        btnFragmentNavBar.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, NavBarFragment())?.addToBackStack(null)?.commit()
        }

        btnFragmentRV.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, RVFragment())?.addToBackStack(null)?.commit()
        }

    }
}