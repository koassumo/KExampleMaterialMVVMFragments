package com.example.kexamplematerialmvvmfragments.ui.fragments_demo_rv

interface ItemTouchHelperAdapter {

    fun onItemMove(fromPosition: Int, toPosition: Int)

    fun onItemDismiss(position: Int)
}