package com.example.kexamplematerialmvvmfragments.ui.fragments_settings

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kexamplematerialmvvmfragments.databinding.TypographyFragmentBinding

class TypographyFragment : Fragment() {

    companion object {
        fun newInstance() = TypographyFragment()
    }
    private var _binding: TypographyFragmentBinding? = null
    private val binding get() = _binding!!
    // (1) объявляем mViewModel
    private lateinit var viewModel: TypographyViewModel

    // объявляем adapter-ы
    lateinit var adapterTypography: RvAdapterTypography


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = TypographyFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // (2) наполнение mViewModel
        viewModel = ViewModelProvider(this).get(TypographyViewModel::class.java)
        // TODO: Use the ViewModel

        // подтягиваем rv, кладем layout на rv
        binding.rvTypography.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        // инициализируем адаптер, кладем его на rv
        adapterTypography = RvAdapterTypography(requireContext())
        binding.rvTypography.adapter = adapterTypography

    }

    override fun onStart() {
        super.onStart()
        //ChipsActivity4.start (this)
//    <<<<<<<<<<<<<<<<[[[  2. Подписка на liveData
//    <<<<<<<<<<<<<<<<[[[  *4. И сразу при Подписке описание реакции подписчика, 4ка выполнится позже
        viewModel.liveDataTypography.observe(this, Observer {
            adapterTypography.adapterList = it     // вызов set
        })

    }

}