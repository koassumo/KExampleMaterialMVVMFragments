package com.example.kexamplematerialmvvmfragments.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.kexamplematerialmvvmfragments.R
import com.example.kexamplematerialmvvmfragments.model.entity.NoteRvButton

import com.example.kexamplematerialmvvmfragments.ui.fragments.ButtonsFragment
import com.example.kexamplematerialmvvmfragments.ui.fragments.bottomsheet.BottomSheetFragment
import kotlinx.android.synthetic.main.item_rv_main_common.view.*

class RvAdapterButtons(fragmentContext: Context) : RecyclerView.Adapter<RvAdapterButtons.ViewHolder>() {

    val adapterContext: Context = fragmentContext
    var adapterList: List<NoteRvButton> = listOf()
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
        fun bind(adapterOnlyOneItemData: NoteRvButton) {
//            itemView.setPaddingRelative(30, 0, 0 , 0)
//            = TextView(context, null, 0, R.style.Headline1)
            itemView.tv_title.text = adapterOnlyOneItemData.title
            when (adapterOnlyOneItemData.imageName) {
                "rv_button_text" -> itemView.iv_pic.setImageResource(R.drawable.rv_button_text)
                "rv_button_toggle" -> itemView.iv_pic.setImageResource(R.drawable.rv_button_toggle)
                "rv_button_gradient" -> itemView.iv_pic.setImageResource(R.drawable.rv_button_gradient)
            }

            println("------------------------------------------------------------- before")
            itemView.setOnClickListener {
                val ttt: String = it.tv_title.text as String
                val activity = adapterContext as AppCompatActivity
                //вариант val activity = it.context as AppCompatActivity
                println("------------------------------------------------------------- after $ttt")
                when (ttt) {
                    "Text\nButton" -> activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, ButtonsFragment())?.addToBackStack(null)?.commit()
                    "Toggle\nButton" -> activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, BottomSheetFragment())?.addToBackStack(null)?.commit()
                    "Gradient\nButton" -> activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, BottomSheetFragment())?.addToBackStack(null)?.commit()
                    //Toast.makeText(adapterContext, "1", Toast.LENGTH_SHORT).show()
                }
                //Toast.makeText(mContext, "------------------------------------------------- $it.id", Toast.LENGTH_LONG).show()
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
    override fun onBindViewHolder(holder: RvAdapterButtons.ViewHolder, position: Int) {
        holder.bind(adapterList[position])  // только одна строчка ! в vh будет - adapterOnlyOneItemData
    }

    // #3. из кода эта функция не вызывается
    override fun getItemCount(): Int {
        return adapterList.size
    }


}