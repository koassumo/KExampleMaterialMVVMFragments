package com.example.kexamplematerialmvvmfragments.ui.fragments_demo_rv.demorv

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kexamplematerialmvvmfragments.databinding.RVFragmentBinding


class RVFragment : Fragment() {

    companion object {
        fun newInstance() = RVFragment()
    }
    private var _binding: RVFragmentBinding? = null
    private val binding get() = _binding!!
    // (1) объявляем mViewModel
    private lateinit var viewModel: RVViewModel
    // объявляем adapter
    lateinit var adapter : RVAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = RVFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // (2) наполнение mViewModel
        viewModel = ViewModelProvider(this).get(RVViewModel::class.java)

        // инициализируем адаптер, кладем его на rv
        adapter = RVAdapter(requireContext())
        binding.rvItems.adapter = adapter
        binding.rvItems.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        //rv_items.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))

    }


    override fun onStart() {
        super.onStart()
        //ChipsActivity4.start (this)
//    <<<<<<<<<<<<<<<<[[[  2. Подписка на liveData
//    <<<<<<<<<<<<<<<<[[[  *4. И сразу при Подписке описание реакции подписчика, 4ка выполнится позже
        viewModel.liveData.observe(this, Observer {
            adapter.aListNoteDemos = it     // вызов set
        })
    }




}