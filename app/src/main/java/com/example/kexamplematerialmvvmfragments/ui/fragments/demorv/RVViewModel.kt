package com.example.kexamplematerialmvvmfragments.ui.fragments.demorv

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kexamplematerialmvvmfragments.model.ItemRepository
import com.example.kexamplematerialmvvmfragments.model.entity.ItemRV


// Вариант 1. Без возможности передачи контекста (owner, lifecycle)
// class MainViewModel : ViewModel() {
// Вариант 2. С возможностью передачи контекста
class RVViewModel : ViewModel() {

    //   <<<<<<<<<<<<<<<<<<<[[   1. выставляем вышку
    val liveData = MutableLiveData<List<ItemRV>>()

    init {
        startTimer()
    }

    private fun startTimer() {
        //    <<<<<<<<<<<<<<<<<<<[[   3. пихаем данные в вышку liveData - она разберется
        liveData.value = ItemRepository.getListItems()
    }



}