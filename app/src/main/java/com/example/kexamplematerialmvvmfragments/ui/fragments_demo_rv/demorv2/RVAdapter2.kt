package com.example.kexamplematerialmvvmfragments.ui.fragments_demo_rv.demorv2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kexamplematerialmvvmfragments.R
import com.example.kexamplematerialmvvmfragments.model.entity.NoteDemoRV
import kotlinx.android.synthetic.main.item_rv_medium_simple.view.*
import kotlinx.android.synthetic.main.item_rv_small_simple.view.*
import kotlinx.android.synthetic.main.item_rv_small_simple.view.tv_description
import kotlinx.android.synthetic.main.item_rv_small_simple.view.tv_title

class RVAdapter2(fragmentContext: Context) : RecyclerView.Adapter<RVAdapter2.BaseViewHolder>() {

    companion object {
        private const val TYPE_SMALL = 1
        private const val TYPE_MEDIUM = 2
    }

    val aContext: Context = fragmentContext

    // не путать set с конструктором
    var aListPair: ArrayList<Pair<NoteDemoRV, Boolean>> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    // ВАРИАНТ №2. Базовый холдер
    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(onlyOnePair: Pair<NoteDemoRV, Boolean>)
    }

    // Первый ViewHolder
    inner class SmallViewHolder(itemView: View) : BaseViewHolder(itemView) {
        // "находим" (для kotlin) нужные вьюшки и связываем их
        override fun bind(onlyOnePair: Pair<NoteDemoRV, Boolean>) {
            itemView.tv_title.text = onlyOnePair.first.mTitle
//            itemView.tv_id.text = onlyOnePair.second.toString()
//            itemView.tv_description.text = onlyOnePair.first.mDescription

            itemView.iv_arrow_down.setOnClickListener {
                toggleText(layoutPosition)
                Toast.makeText(aContext, "layoutPosition: $layoutPosition", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    // ВТОРОЙ ViewHolder
    inner class MediumViewHolder(itemView: View) : BaseViewHolder(itemView) {
        // "находим" (для kotlin) нужные вьюшки и связываем их
        override fun bind(onlyOnePair: Pair<NoteDemoRV, Boolean>) {

            itemView.tv_title.text = onlyOnePair.first.mTitle
            itemView.tv_description.text = onlyOnePair.first.mDescription

            itemView.iv_arrow_up.setOnClickListener { toggleText(layoutPosition) }
        }
    }


    private fun toggleText(position: Int) {
//            aListNoteDemos [layoutPosition] = aListNoteDemos[layoutPosition].let {
//                it.first to !it.second
//            }
        aListPair[position] = aListPair[position].first to !aListPair[position].second
        notifyItemChanged(position)
    }


    // Метод имеет тип - не конкретный, а общий холдер  -": RecyclerView.ViewHolder"
    // но возвращает конкретный в зависимости от определенного типа Note
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val myInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_SMALL -> SmallViewHolder(
                myInflater.inflate(
                    R.layout.item_rv_small_simple,
                    parent,
                    false
                )
            )
            else -> MediumViewHolder(
                myInflater.inflate(
                    R.layout.item_rv_medium_simple,
                    parent,
                    false
                )
            )
        }
    }

    // Метод получает как общий холдер, и определяет его конкретный вид через as
    // Передать строчку из arrayList во vh через метод bind
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(aListPair[position])
    }

    // 3. из кода эта функция не вызывается
    override fun getItemCount(): Int {
        return aListPair.size
    }

    // определяем тип конкретного Note на основе его полей и позиции
    override fun getItemViewType(position: Int): Int {
        return when {
            aListPair[position].second -> TYPE_MEDIUM
            else -> TYPE_SMALL
        }
    }

    private fun generateItem(): NoteDemoRV = NoteDemoRV("333", "333", "333")

}
