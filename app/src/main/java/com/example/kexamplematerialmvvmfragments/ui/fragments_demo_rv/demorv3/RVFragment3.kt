package com.example.kexamplematerialmvvmfragments.ui.fragments_demo_rv.demorv3

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kexamplematerialmvvmfragments.R
import kotlinx.android.synthetic.main.r_v_fragment.*

class RVFragment3 : Fragment() {

    companion object {
        fun newInstance() = RVFragment3()
    }
    // (1) объявляем mViewModel
    private lateinit var viewModel: RVViewModel3
    // объявляем adapter
    lateinit var adapter: RVAdapter3

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.r_v_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RVViewModel3::class.java)

        adapter = RVAdapter3(context!!)
        rv_items.adapter = adapter
        rv_items.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_items.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        fab_demo_rv.setOnClickListener { adapter.appendItem() }
    }

    override fun onStart() {
        super.onStart()
        viewModel.liveData.observe(this, Observer {
            adapter.aListNoteDemos = it     // вызов set
        })
    }

}