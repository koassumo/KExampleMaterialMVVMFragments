package com.example.kexamplematerialmvvmfragments.ui.fragments.demorv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kexamplematerialmvvmfragments.R
import com.example.kexamplematerialmvvmfragments.model.entity.NoteDemoRV
import kotlinx.android.synthetic.main.item_rv_small.view.*

class RVAdapter (fragmentContext: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_SMALL = 1
        private const val TYPE_MEDIUM = 2
    }

    val aContext: Context = fragmentContext

    // не путать set с конструктором
    var aListNoteDemos: MutableList<NoteDemoRV> = mutableListOf()
        set (value) {
            field = value
            notifyDataSetChanged()
        }

    // ВАРИАНТ №1. Каждый холдер отдельно

    // Первый ViewHolder
    inner class SmallViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // "находим" (для kotlin) нужные вьюшки и связываем их
        fun bind(onlyOneNote: NoteDemoRV) {

            itemView.tv_title.text = onlyOneNote.mTitle
            itemView.tv_id.text = onlyOneNote.mId
            itemView.tv_description.text = onlyOneNote.mDescription

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
            }


        }
    }

    // Второй ViewHolder
    inner class MediumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // "находим" (для kotlin) нужные вьюшки и связываем их
        fun bind(onlyOneNote: NoteDemoRV) {
            itemView.tv_title.text = onlyOneNote.mTitle
            itemView.tv_id.text = onlyOneNote.mId
            itemView.tv_description.text = onlyOneNote.mDescription
        }
    }

    // Третий ViewHolder (для TYPE_HEADERS)
    inner class HeadersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // "находим" (для kotlin) нужные вьюшки и связываем их
        fun bind(onlyOneNote: NoteDemoRV) {
            itemView.tv_title.text = onlyOneNote.mTitle
        }
    }


    // Метод имеет тип - не конкретный, а общий холдер  -": RecyclerView.ViewHolder"
    // но возвращает конкретный в зависимости от определенного типа Note
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val myInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_HEADER -> HeadersViewHolder(myInflater.inflate(R.layout.item_rv_header, parent, false))
            TYPE_SMALL -> SmallViewHolder(myInflater.inflate(R.layout.item_rv_small, parent, false))
            else -> MediumViewHolder(myInflater.inflate(R.layout.item_rv_medium, parent, false))
        }
    }

    // Метод получает как общий холдер, и определяет его конкретный вид через as
    // Передать строчку из arrayList во vh через метод bind
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // тут приходится определять какой именно холдер нам передали
        // нельзя просто вызвать метод bind, т.к. он не override и не обязан содержаться к холдере
        // можно обойти с помощью абстрактного класса
        when (getItemViewType(position)) {
            TYPE_HEADER -> {
                holder as HeadersViewHolder
                holder.bind(aListNoteDemos[position])
            }
            TYPE_SMALL -> {
                holder as SmallViewHolder
                holder.bind(aListNoteDemos[position])
            }
            else -> {
                holder as MediumViewHolder
                holder.bind(aListNoteDemos[position])
            }
        }
    }

    // 3. из кода эта функция не вызывается
    override fun getItemCount(): Int {
        return aListNoteDemos.size
    }


    // определяем тип конкрекного Note на основе его полей и позиции
    override fun getItemViewType(position: Int): Int {
        return when {
            position == 0 -> TYPE_HEADER
            aListNoteDemos[position].mId.isNullOrBlank() -> TYPE_HEADER
            aListNoteDemos[position].mDescription.isNullOrBlank() -> TYPE_SMALL
            else -> TYPE_MEDIUM
        }
    }
}







