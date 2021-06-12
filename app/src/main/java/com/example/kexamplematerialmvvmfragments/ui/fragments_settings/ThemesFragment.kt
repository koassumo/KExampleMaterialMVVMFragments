package com.example.kexamplematerialmvvmfragments.ui.fragments_settings

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kexamplematerialmvvmfragments.R
import com.example.kexamplematerialmvvmfragments.ui.main.MainActivity.Companion.themeFlag
import com.example.kexamplematerialmvvmfragments.viewmodel.ThemesViewModel
import kotlinx.android.synthetic.main.themes_fragment.*

class ThemesFragment : Fragment() {

    companion object {
        fun newInstance() = ThemesFragment()
//        var flag = 0
    }

    private lateinit var viewModel: ThemesViewModel

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        when (flag) {
//            0 -> context?.setTheme(R.style.IndigoAppTheme)
//            1 -> context?.setTheme(R.style.GreenAppTheme)
//            2 -> context?.setTheme(R.style.BrownAppTheme)
//            3 -> context?.setTheme(R.style.YellowAppTheme)
//        }

        return inflater.inflate(R.layout.themes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ThemesViewModel::class.java)
        // TODO: Use the ViewModel

    }

    override fun onResume() {
        super.onResume()

        btnIndigo.setOnClickListener{
            themeFlag = 0
            activity?.recreate()
        }

        btnGreen.setOnClickListener{
            themeFlag = 1
            activity?.recreate()
        }

        btnBrown.setOnClickListener{
            themeFlag = 2
            activity?.recreate()
        }

        btnYellow.setOnClickListener{
            themeFlag = 3
            activity?.recreate()
        }


    }


}