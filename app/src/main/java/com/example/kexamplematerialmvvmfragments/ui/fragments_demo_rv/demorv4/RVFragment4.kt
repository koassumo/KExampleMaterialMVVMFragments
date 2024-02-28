package com.example.kexamplematerialmvvmfragments.ui.fragments_demo_rv.demorv4

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kexamplematerialmvvmfragments.databinding.RVFragmentBinding

class RVFragment4 : Fragment() {

    companion object {
        fun newInstance() = RVFragment4()
    }
    private var _binding: RVFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: RVViewModel4
    lateinit var adapter: RVAdapter4
    private lateinit var itemTouchHelper: ItemTouchHelper

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = RVFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(RVViewModel4::class.java)

        adapter = RVAdapter4(requireContext())
        itemTouchHelper = ItemTouchHelper (ItemTouchHelperCallback(adapter))
        itemTouchHelper.attachToRecyclerView(binding.rvItems)
        binding.rvItems.adapter = adapter
        binding.rvItems.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        //rv_items.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        //fab_demo_rv.setOnClickListener { adapter.appendItem() }
    }

    override fun onStart() {
        super.onStart()
        //ChipsActivity4.start (this)
//    <<<<<<<<<<<<<<<<[[[  2. Подписка на liveData
//    <<<<<<<<<<<<<<<<[[[  *4. И сразу при Подписке описание реакции подписчика, 4ка выполнится позже
        viewModel.liveData.observe(this, Observer {
            adapter.aListPair = it     // вызов set
        })
    }


}