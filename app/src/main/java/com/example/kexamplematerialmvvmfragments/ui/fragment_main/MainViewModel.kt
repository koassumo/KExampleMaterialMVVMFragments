package com.example.kexamplematerialmvvmfragments.ui.fragment_main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kexamplematerialmvvmfragments.model.RepositoryRv
import com.example.kexamplematerialmvvmfragments.model.RepositoryRvBottomSheet
import com.example.kexamplematerialmvvmfragments.model.RepositoryRvButton
import com.example.kexamplematerialmvvmfragments.model.RepositoryRvEditView
import com.example.kexamplematerialmvvmfragments.model.entity.NoteRv
import com.example.kexamplematerialmvvmfragments.model.entity.NoteRvBottomSheet
import com.example.kexamplematerialmvvmfragments.model.entity.NoteRvButton
import com.example.kexamplematerialmvvmfragments.model.entity.NoteRvEditView

// Вариант 1. Без возможности передачи контекста (owner, lifecycle) здесь -
class MainViewModel : ViewModel() {

    //   <<<<<<<<<<<<<<<<<<<[[   1. выставляем вышки
    val liveDataButtons = MutableLiveData<List<NoteRvButton>>()
    val liveDataEditView = MutableLiveData<List<NoteRvEditView>>()
    val liveDataBottomSheet = MutableLiveData<List<NoteRvBottomSheet>>()
    val liveDataChips = MutableLiveData<List<NoteRv>>()
    val liveDataConstraintLayout = MutableLiveData<List<NoteRv>>()
    val liveDataBottomNav = MutableLiveData<List<NoteRv>>()
    val liveDataBottomAppBar = MutableLiveData<List<NoteRv>>()
    val liveDataDemoRV = MutableLiveData<List<NoteRv>>()
    val liveDataSelections = MutableLiveData <List<NoteRv>> ()
    val liveDataTabs = MutableLiveData <List<NoteRv>> ()
    val liveDataAnimation = MutableLiveData <List<NoteRv>> ()

    init {
        updateListFirst()
    }

    private fun updateListFirst() {
        //    <<<<<<<<<<<<<<<<<<<[[   3. пихаем данные в вышку liveData - она разберется
        liveDataButtons.value = RepositoryRvButton.getList()
        liveDataEditView.value = RepositoryRvEditView.getList()
        liveDataBottomSheet.value = RepositoryRvBottomSheet.getList()

        liveDataChips.value = RepositoryRv.getListRvChips()
        liveDataConstraintLayout.value = RepositoryRv.getListRvConstraintLayout()
        liveDataBottomNav.value = RepositoryRv.getListRvBottomNav()
        liveDataBottomAppBar.value = RepositoryRv.getListRvBottomAppBar()
        liveDataDemoRV.value = RepositoryRv.getListRvDemoRV()
        liveDataSelections.value = RepositoryRv.getListRvSelections()
        liveDataTabs.value = RepositoryRv.getListRvTabs()
        liveDataAnimation.value = RepositoryRv.getListRvAnimation()
    }
}