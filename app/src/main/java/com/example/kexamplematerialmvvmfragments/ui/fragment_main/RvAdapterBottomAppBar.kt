package com.example.kexamplematerialmvvmfragments.ui.fragment_main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.kexamplematerialmvvmfragments.R
import com.example.kexamplematerialmvvmfragments.model.entity.NoteRv
import com.example.kexamplematerialmvvmfragments.ui.fragments.bottomappbar.BottomAppBarFragment

import kotlinx.android.synthetic.main.item_rv_main_common.view.*

class RvAdapterBottomAppBar(fragmentContext: Context) : RecyclerView.Adapter<RvAdapterBottomAppBar.ViewHolder>() {

    val adapterContext: Context = fragmentContext
    var adapterList: List<NoteRv> = listOf()
        // Это котлиновский set, не путать с конструктором
        // Суть передачи через list именно через set - в том, что при таком способе не нарушается анимация
        // (как если бы запихать в конструктор и потом пересоздавать адаптер или через функцию менять list
        set(value) {       // value - хрень, поступившая на вход
            field = value   // field - поле в переменной, здесь - List, т.е. тут без всяких проверок
            // и преобразований кидаем входящий хрень (value) в поле переменной
            notifyDataSetChanged()
        }

    // (#1) при создании vh - onCreateViewHolder (описан ниже) - в него передается itemView
    // (#2) при вызове у vh метода bind (описан ниже) - в него передается данные из array, чтобы связать с itemView
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // "находим" (для kotlin) нужные вьюшки и связываем их
        fun bind(adapterOnlyOneItemData: NoteRv) {
            itemView.tv_title.text = adapterOnlyOneItemData.title
            when (adapterOnlyOneItemData.imageName) {
                "rv_bottom_app_bar_1" -> itemView.iv_pic.setImageResource(R.drawable.rv_bottom_app_bar)
                "rv_bottom_app_bar_2" -> itemView.iv_pic.setImageResource(R.drawable.rv_bottom_app_bar)
                "rv_bottom_app_bar_3" -> itemView.iv_pic.setImageResource(R.drawable.rv_bottom_app_bar)
            }

            itemView.setOnClickListener {
                val ttt: String = it.tv_title.text as String
                val activity = adapterContext as AppCompatActivity
                //вариант val activity = it.context as AppCompatActivity
                when (ttt) {
                    "Bottom App Bar" -> activity?.supportFragmentManager?.beginTransaction()?.replace(
                        R.id.container, BottomAppBarFragment()
                    )?.addToBackStack(null)?.commit()
//                    "Bottom App Bar 2" -> activity?.supportFragmentManager?.beginTransaction()?.replace(
//                        R.id.container, BottomAppBarFragment()
//                    )?.addToBackStack(null)?.commit()
//                    "Bottom App Bar 3" -> activity?.supportFragmentManager?.beginTransaction()?.replace(
//                        R.id.container, BottomAppBarFragment()
//                    )?.addToBackStack(null)?.commit()
                }
            }
        }
    }

    // Три обязательных переопределяемых класса адаптера:

    // #1. Создать vh путем передачи в него item_view.xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv_main_common, parent, false)
        )

    // #2. Передать строчку из arrayList во vh через метод bind
    override fun onBindViewHolder(holder: RvAdapterBottomAppBar.ViewHolder, position: Int) {
        holder.bind(adapterList[position])  // только одна строчка ! в vh будет - adapterOnlyOneItemData
    }

    // #3. из кода эта функция не вызывается
    override fun getItemCount(): Int {
        return adapterList.size
    }


}