package com.example.kexamplematerialmvvmfragments.ui.fragment_main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.kexamplematerialmvvmfragments.R
import com.example.kexamplematerialmvvmfragments.model.entity.NoteRvEditView
import com.example.kexamplematerialmvvmfragments.ui.fragments.edittext.EditTextFragment
import kotlinx.android.synthetic.main.item_rv_main_common.view.*


class RvAdapterEditView (fragmentContext: Context) : RecyclerView.Adapter<RvAdapterEditView.ViewHolder> () {

    val adapterContext: Context = fragmentContext
    var adapterList: List <NoteRvEditView> = listOf()
        // это котлиновский set, не путать с конструктором
        set (value) {       // value - хрень, поступившая на вход
            field = value   // field - поле в переменной, здесь - List, т.е. тут без всяких проверок
            // и преобразований кидаем входящий хрень (value) в поле переменной
            notifyDataSetChanged()
        }

    // (#1) при создании vh - onCreateViewHolder (описан ниже) - в него передается itemView
    // (#2) при вызове у vh метода bind (описан ниже) - в него передается данные из array, чтобы связать с itemView
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder (itemView) {

        // "находим" (для kotlin) нужные вьюшки и связываем их
        fun bind(adapterOnlyOneItemData: NoteRvEditView) {
//            itemView.setPaddingRelative(30, 0, 0 , 0)
//            = TextView(context, null, 0, R.style.Headline1)
            itemView.tv_title.text = adapterOnlyOneItemData.title
            when (adapterOnlyOneItemData.imageName) {
                "rv_outlined_box" -> itemView.iv_pic.setImageResource(R.drawable.rv_edit_text_outlined)
                "rv_filled_box" -> itemView.iv_pic.setImageResource(R.drawable.rv_edit_text_filled)
            }
            itemView.setOnClickListener {
                val ttt: String = it.tv_title.text as String
                val activity = adapterContext as AppCompatActivity
                when (ttt) {
                    "Outlined\nBox" ->  activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, EditTextFragment())?.addToBackStack(null)?.commit()
                    "Filled\nBox" ->  activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, EditTextFragment())?.addToBackStack(null)?.commit()
                }
            }
        }
    }

    // Три обязательных переопределяемых класса адаптера:

    // #1. Создать vh путем передачи в него item_view.xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_main_common, parent, false))

    // #2. Передать строчку из arrayList во vh через метод bind
    override fun onBindViewHolder(holder: RvAdapterEditView.ViewHolder, position: Int) {
        holder.bind(adapterList [position])  // только одна строчка ! в vh будет - adapterOnlyOneItemData
    }

    // #3. из кода эта функция не вызывается
    override fun getItemCount(): Int {
        return adapterList.size
    }


}