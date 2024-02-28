package com.example.kexamplematerialmvvmfragments.ui.fragments_demo_rv.demorv3

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kexamplematerialmvvmfragments.databinding.RVFragment3Binding



class RVFragment3 : Fragment() {

    companion object {
        fun newInstance() = RVFragment3()
    }
    private var _binding: RVFragment3Binding? = null
    private val binding get() = _binding!!
    // (1) объявляем mViewModel
    private lateinit var viewModel: RVViewModel3
    // объявляем adapter
    lateinit var adapter: RVAdapter3

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = RVFragment3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(RVViewModel3::class.java)

        adapter = RVAdapter3(requireContext())
        binding.rvItems.adapter = adapter
        binding.rvItems.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        //rv_items.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        binding.fabDemoRv.setOnClickListener { adapter.appendItem() }
    }

    override fun onStart() {
        super.onStart()
        viewModel.liveData.observe(this, Observer {
            adapter.aListNoteDemos = it     // вызов set
        })
    }

}