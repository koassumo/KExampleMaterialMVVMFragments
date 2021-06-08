package com.example.kexamplematerialmvvmfragments.ui.fragmentsettings

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kexamplematerialmvvmfragments.model.RepositoryRvTypography
import com.example.kexamplematerialmvvmfragments.model.entity.NoteRvTypography

class TypographyViewModel: ViewModel() {
    //   <<<<<<<<<<<<<<<<<<<[[   1. выставляем вышки
    val liveDataTypography = MutableLiveData<List<NoteRvTypography>>()

    init {
        updateListFirst()
    }

    private fun updateListFirst() {
        //    <<<<<<<<<<<<<<<<<<<[[   3. пихаем данные в вышку liveData - она разберется
        liveDataTypography.value = RepositoryRvTypography.getList()
    }

}