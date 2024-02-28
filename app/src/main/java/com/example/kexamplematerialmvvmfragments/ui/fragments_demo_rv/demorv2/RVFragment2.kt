package com.example.kexamplematerialmvvmfragments.ui.fragments_demo_rv.demorv2

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kexamplematerialmvvmfragments.databinding.RVFragmentBinding


class RVFragment2 : Fragment() {

    private var _binding: RVFragmentBinding? = null
    private val binding get() = _binding!!

    // (1) объявляем mViewModel
    private lateinit var viewModel: RVViewModel2
    // объявляем adapter
    private lateinit var adapter: RVAdapter2

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = RVFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[RVViewModel2::class.java]

        adapter = RVAdapter2(requireContext())
        binding.rvItems.adapter = adapter
        binding.rvItems.layoutManager = LinearLayoutManager(context)
    }

    override fun onStart() {
        super.onStart()
        viewModel.liveData.observe(viewLifecycleOwner, Observer {
            adapter.aListPair = it
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
