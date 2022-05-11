package com.example.kexamplematerialmvvmfragments.ui.fragments_demo_rv

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.kexamplematerialmvvmfragments.model.entity.NoteDemoRV

abstract class MyBaseViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(onlyOnePair: Pair<NoteDemoRV, Boolean>)
}