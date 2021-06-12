package com.example.kexamplematerialmvvmfragments.ui.fragments_demo_rv.demorv2

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

class RVFragment2 : Fragment() {

    companion object {
        fun newInstance() = RVFragment2()
    }

    // (1) объявляем mViewModel
    private lateinit var viewModel: RVViewModel2
    // объявляем adapter
    lateinit var adapter: RVAdapter2

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.r_v_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // (2) наполнение mViewModel
        viewModel = ViewModelProvider(this).get(RVViewModel2::class.java)

        adapter = RVAdapter2 (context!!)
        rv_items.adapter = adapter
        rv_items.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_items.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
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