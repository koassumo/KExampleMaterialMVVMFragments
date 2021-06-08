package com.example.kexamplematerialmvvmfragments.ui.fragmentsettings

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.kexamplematerialmvvmfragments.R
import com.example.kexamplematerialmvvmfragments.model.entity.NoteRvTypography
import kotlinx.android.synthetic.main.item_rv_typography.view.*

class RvAdapterTypography (fragmentContext: Context) : RecyclerView.Adapter<RvAdapterTypography.ViewHolder>() {

    val adapterContext: Context = fragmentContext
    var adapterList: List<NoteRvTypography> = listOf()
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
        fun bind(adapterOnlyOneItemData: NoteRvTypography) {
//            itemView.setPaddingRelative(30, 0, 0 , 0)
//            = TextView(context, null, 0, R.style.Headline1)
            itemView.tv_title.text = adapterOnlyOneItemData.title
            itemView.tv_attr.text = adapterOnlyOneItemData.attr
            when (adapterOnlyOneItemData.title) {
                "Headline1" -> itemView.tv_hello.setTextAppearance(R.style.TextAppearance_MaterialComponents_Headline1)
                "Headline2" -> itemView.tv_hello.setTextAppearance(R.style.TextAppearance_MaterialComponents_Headline2)
                "Headline3" -> itemView.tv_hello.setTextAppearance(R.style.TextAppearance_MaterialComponents_Headline3)
                "Headline4" -> itemView.tv_hello.setTextAppearance(R.style.TextAppearance_MaterialComponents_Headline4)
                "Headline5" -> itemView.tv_hello.setTextAppearance(R.style.TextAppearance_MaterialComponents_Headline5)
                "Headline6" -> itemView.tv_hello.setTextAppearance(R.style.TextAppearance_MaterialComponents_Headline6)
                "Subtitle1" -> itemView.tv_hello.setTextAppearance(R.style.TextAppearance_MaterialComponents_Subtitle1)
                "Subtitle2" -> itemView.tv_hello.setTextAppearance(R.style.TextAppearance_MaterialComponents_Subtitle2)
                "Body1" -> itemView.tv_hello.setTextAppearance(R.style.TextAppearance_MaterialComponents_Body1)
                "Body2" -> itemView.tv_hello.setTextAppearance(R.style.TextAppearance_MaterialComponents_Body2)
                "Button" -> itemView.tv_hello.setTextAppearance(R.style.TextAppearance_MaterialComponents_Button)
                "Caption" -> itemView.tv_hello.setTextAppearance(R.style.TextAppearance_MaterialComponents_Caption)
                "Overline" -> itemView.tv_hello.setTextAppearance(R.style.TextAppearance_MaterialComponents_Overline)
            }
        }
    }

    // Три обязательных переопределяемых класса адаптера:
    // #1. Создать vh путем передачи в него item_view.xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv_typography, parent, false)
        )

    // #2. Передать строчку из arrayList во vh через метод bind
    override fun onBindViewHolder(holder: RvAdapterTypography.ViewHolder, position: Int) {
        holder.bind(adapterList[position])  // только одна строчка ! в vh будет - adapterOnlyOneItemData
    }

    // #3. из кода эта функция не вызывается
    override fun getItemCount(): Int {
        return adapterList.size
    }


}