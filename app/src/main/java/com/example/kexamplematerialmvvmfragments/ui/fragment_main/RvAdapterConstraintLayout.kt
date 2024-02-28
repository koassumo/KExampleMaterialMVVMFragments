package com.example.kexamplematerialmvvmfragments.ui.fragment_main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.kexamplematerialmvvmfragments.R
import com.example.kexamplematerialmvvmfragments.model.entity.NoteRv
import com.example.kexamplematerialmvvmfragments.ui.fragments.constrained.ConstrainedLayoutFragment

class RvAdapterConstraintLayout (fragmentContext: Context) : RecyclerView.Adapter<RvAdapterConstraintLayout.ViewHolder>() {

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
        private val tv_title = itemView.findViewById<TextView>(R.id.tv_title)
        private val iv_pic = itemView.findViewById<ImageView>(R.id.iv_pic)
        // "находим" (для kotlin) нужные вьюшки и связываем их
        fun bind(adapterOnlyOneItemData: NoteRv) {
            tv_title.text = adapterOnlyOneItemData.title
            when (adapterOnlyOneItemData.imageName) {
                "rv_constraint_layout_1" -> iv_pic.setImageResource(R.drawable.rv_constrained_layout)
                "rv_constraint_layout_2" -> iv_pic.setImageResource(R.drawable.rv_constrained_layout)
                "rv_constraint_layout_3" -> iv_pic.setImageResource(R.drawable.rv_constrained_layout)
            }

            itemView.setOnClickListener {
                val ttt: String = tv_title.text as String
                val activity = adapterContext as AppCompatActivity
                //вариант val activity = it.context as AppCompatActivity
                when (ttt) {
                    "ConstraintLayout" -> activity?.supportFragmentManager?.beginTransaction()?.replace(
                        R.id.container, ConstrainedLayoutFragment()
                    )?.addToBackStack(null)?.commit()
//                    "ConstraintLayout2" -> activity?.supportFragmentManager?.beginTransaction()?.replace(
//                        R.id.container, ConstrainedLayoutFragment()
//                    )?.addToBackStack(null)?.commit()
//                    "ConstraintLayout3" -> activity?.supportFragmentManager?.beginTransaction()?.replace(
//                        R.id.container, ConstrainedLayoutFragment()
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
    override fun onBindViewHolder(holder: RvAdapterConstraintLayout.ViewHolder, position: Int) {
        holder.bind(adapterList[position])  // только одна строчка ! в vh будет - adapterOnlyOneItemData
    }

    // #3. из кода эта функция не вызывается
    override fun getItemCount(): Int {
        return adapterList.size
    }


}