package com.example.kexamplematerialmvvmfragments.ui.fragments_demo_rv.demorv2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kexamplematerialmvvmfragments.model.RepositoryDemoRV
import com.example.kexamplematerialmvvmfragments.model.entity.NoteDemoRV

class RVViewModel2 : ViewModel() {

    //   <<<<<<<<<<<<<<<<<<<[[   1. выставляем вышку
    val liveData = MutableLiveData<ArrayList<Pair<NoteDemoRV, Boolean>>>()

    init {
        updateListFirst()
    }

    private fun updateListFirst() {
        val listData: MutableList<NoteDemoRV> = RepositoryDemoRV.getListNoteDemoRV().toMutableList()
        val listPair: ArrayList<Pair<NoteDemoRV, Boolean>> = ArrayList ()
        for (i in listData) {
            listPair.add(i to false)
        }



        //    <<<<<<<<<<<<<<<<<<<[[   3. пихаем данные в вышку liveData - она разберется
        liveData.value = listPair
    }



}