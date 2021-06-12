package com.example.kexamplematerialmvvmfragments.ui.fragments_demo_rv.demorv4

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kexamplematerialmvvmfragments.model.RepositoryDemoRV
import com.example.kexamplematerialmvvmfragments.model.entity.NoteDemoRV

class RVViewModel4 : ViewModel() {

    //   <<<<<<<<<<<<<<<<<<<[[   1. выставляем вышку
    val liveData = MutableLiveData<MutableList<Pair<NoteDemoRV, Boolean>>>()

    init {
        updateListFirst()
    }

    private fun updateListFirst() {
        var listData: MutableList<NoteDemoRV> = RepositoryDemoRV.getListNoteDemoRV().toMutableList()
        var listPair: MutableList<Pair<NoteDemoRV, Boolean>> = ArrayList()
        for (oneData in listData) {
            listPair.add(oneData to false)
        }



        //    <<<<<<<<<<<<<<<<<<<[[   3. пихаем данные в вышку liveData - она разберется
        liveData.value = listPair
    }


}