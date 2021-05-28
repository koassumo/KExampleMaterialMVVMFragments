package com.example.kexamplematerialmvvmfragments.ui.fragments.demorv

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kexamplematerialmvvmfragments.R
import kotlinx.android.synthetic.main.r_v_fragment.*

class RVFragment : Fragment() {

    companion object {
        fun newInstance() = RVFragment()
    }

    // (1) объявляем mViewModel
    private lateinit var viewModel: RVViewModel
    // объявляем adapter
    lateinit var adapter : RVAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.r_v_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // (2) наполнение mViewModel
        viewModel = ViewModelProvider(this).get(RVViewModel::class.java)

        // подтягиваем rv, кладем layout на rv
        rv_items.layoutManager = GridLayoutManager(context, 2)
        // инициализируем адаптер, кладем его на rv
        adapter = RVAdapter(context!!)
        rv_items.adapter = adapter

    }


    override fun onStart() {
        super.onStart()
        //ChipsActivity4.start (this)
//    <<<<<<<<<<<<<<<<[[[  2. Подписка на liveData
//    <<<<<<<<<<<<<<<<[[[  *4. И сразу при Подписке описание реакции подписчика, 4ка выполнится позже
        viewModel.liveData.observe(this, Observer {
            adapter.aListItems = it     // вызов set
        })
    }




}