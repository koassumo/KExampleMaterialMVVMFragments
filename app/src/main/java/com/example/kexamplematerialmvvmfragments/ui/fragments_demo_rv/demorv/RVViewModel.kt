package com.example.kexamplematerialmvvmfragments.ui.fragments_demo_rv.demorv

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kexamplematerialmvvmfragments.model.RepositoryDemoRV
import com.example.kexamplematerialmvvmfragments.model.entity.NoteDemoRV


// Вариант 1. Без возможности передачи контекста (owner, lifecycle)
// class MainViewModel : ViewModel() {
// Вариант 2. С возможностью передачи контекста
class RVViewModel : ViewModel() {

    //   <<<<<<<<<<<<<<<<<<<[[   1. выставляем вышку
    val liveData = MutableLiveData<MutableList<NoteDemoRV>>()

    init {
        updateListFirst()
    }

    private fun updateListFirst() {
        //        var listData: MutableList<NoteDemoRV> = RepositoryDemoRV.getListNoteDemoRV().toMutableList()
        // добавляем headers в полученный список
        val listData: MutableList<NoteDemoRV> = RepositoryDemoRV.getListNoteDemoRV().toMutableList()
        listData.add(0, NoteDemoRV(null, "This Is Top Header", null))
        var i = 4
        while (listData.size > i) {
            listData.add(i, NoteDemoRV(null, "This Is Inner Header", null))
            i +=4
        }
        listData.add(NoteDemoRV(null, "This Is Footer", null))


        //    <<<<<<<<<<<<<<<<<<<[[   3. пихаем данные в вышку liveData - она разберется
        liveData.value = listData
    }



}