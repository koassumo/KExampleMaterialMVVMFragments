package com.example.kexamplematerialmvvmfragments.ui.fragments_settings

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.kexamplematerialmvvmfragments.databinding.ThemesFragmentBinding
import com.example.kexamplematerialmvvmfragments.ui.MainActivity.Companion.themeFlag

class ThemesFragment : Fragment() {

    companion object {
        fun newInstance() = ThemesFragment()
//        var flag = 0
    }

    private var _binding: ThemesFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ThemesViewModel


//    private var rootView: View? = null

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

//        when (flag) {
//            0 -> context?.setTheme(R.style.IndigoAppTheme)
//            1 -> context?.setTheme(R.style.GreenAppTheme)
//            2 -> context?.setTheme(R.style.BrownAppTheme)
//            3 -> context?.setTheme(R.style.YellowAppTheme)
//        }

        _binding = ThemesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ThemesViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()

//
//        rootView?.findViewById<Button>(R.id.btnIndigo)?.setOnClickListener {
//            themeFlag = 0
//            activity?.recreate()
//        }
//
//        rootView?.findViewById<Button>(R.id.btnGreen)?.setOnClickListener {
//            themeFlag = 1
//            activity?.recreate()
//        }
//
//
//
//        rootView?.findViewById<Button>(R.id.btnBrown)?.setOnClickListener {
//            themeFlag = 2
//            activity?.recreate()
//        }
//
//
//
//        rootView?.findViewById<Button>(R.id.btnYellow)?.setOnClickListener {
//            themeFlag = 3
//            activity?.recreate()
//        }
//


        binding.btnIndigo.setOnClickListener{
            themeFlag = 0
            activity?.recreate()
        }


        binding.btnGreen.setOnClickListener{
            themeFlag = 1
            activity?.recreate()
        }

        binding.btnBrown.setOnClickListener{
            themeFlag = 2
            activity?.recreate()
        }

        binding.btnYellow.setOnClickListener{
            themeFlag = 3
            activity?.recreate()
        }


    }


}