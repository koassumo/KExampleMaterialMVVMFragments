package com.example.kexamplematerialmvvmfragments.ui.fragments.demorv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kexamplematerialmvvmfragments.R
import com.example.kexamplematerialmvvmfragments.model.entity.ItemRV
import kotlinx.android.synthetic.main.item_rv.view.*

class RVAdapter (fragmentContext: Context): RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    val aContext: Context = fragmentContext

    // не путать set с конструктором
    var aListItems: List<ItemRV> = listOf()
        set (value) {
            field = value
            notifyDataSetChanged()
        }

    // (Один) при создании vh - onCreateViewHolder - в него передается itemView
    // (Два) при вызове у vh метода bind - в него передается данные из array, чтобы связать с itemView
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // "находим" (для kotlin) нужные вьюшки и связываем их
        fun bind(aVhItem: ItemRV) {

            itemView.tv_title.text = aVhItem.mTitle
            itemView.tv_id.text = aVhItem.mId
            itemView.tv_description.text = aVhItem.mDescription
            println("------------------------------------------------------------- before")
            itemView.setOnClickListener {
                val ttt: String = it.tv_id.text as String
                println("------------------------------------------------------------- after $ttt")
                when (ttt) {
                    "11" ->  Toast.makeText(aContext, "1", Toast.LENGTH_SHORT).show()
                    "12" ->  Toast.makeText(aContext, "2", Toast.LENGTH_SHORT).show()
                    "13" ->  Toast.makeText(aContext, it.tv_description.text, Toast.LENGTH_SHORT).show()
                    "14" ->  Toast.makeText(aContext, it.tv_description.text, Toast.LENGTH_SHORT).show()
                    "15" ->  Toast.makeText(aContext, it.tv_description.text, Toast.LENGTH_SHORT).show()
                    "16" ->  Toast.makeText(aContext, it.tv_description.text, Toast.LENGTH_SHORT).show()
                    "17" ->  Toast.makeText(aContext, it.tv_description.text, Toast.LENGTH_SHORT).show()
                }
                //Toast.makeText(mContext, "------------------------------------------------- $it.id", Toast.LENGTH_LONG).show()
            }
        }
    }

    // 1. Создать vh путем передачи в него item_view.xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false))

    // 2. Передать строчку из arrayList во vh через метод bind
    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {
        holder.bind(aListItems [position])
    }

    // 3. из кода эта функция не вызывается
    override fun getItemCount(): Int {
        return aListItems.size
    }
}







