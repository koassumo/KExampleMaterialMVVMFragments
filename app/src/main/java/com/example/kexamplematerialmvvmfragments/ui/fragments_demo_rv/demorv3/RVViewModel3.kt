package com.example.kexamplematerialmvvmfragments.ui.fragments_demo_rv.demorv3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kexamplematerialmvvmfragments.model.RepositoryDemoRV
import com.example.kexamplematerialmvvmfragments.model.entity.NoteDemoRV

class RVViewModel3 : ViewModel() {

    //   <<<<<<<<<<<<<<<<<<<[[   1. выставляем вышку
    val liveData = MutableLiveData<MutableList<NoteDemoRV>>()

    init {
        updateListFirst()
    }

    private fun updateListFirst() {
        val listData: MutableList<NoteDemoRV> = RepositoryDemoRV.getListNoteDemoRV().toMutableList()
        listData.add(0, NoteDemoRV(null, "Top Header", null))
        var i = 6
        while (listData.size > i) {
            listData.add(i, NoteDemoRV(null, "Inner Header", null))
            i += 6
        }
        listData.add(NoteDemoRV(null, "Footer", null))

        //    <<<<<<<<<<<<<<<<<<<[[   3. пихаем данные в вышку liveData - она разберется
        liveData.value = listData
    }


}