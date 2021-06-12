package com.example.kexamplematerialmvvmfragments.ui.fragments_demo_rv.demorv4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kexamplematerialmvvmfragments.R
import com.example.kexamplematerialmvvmfragments.model.entity.NoteDemoRV
import com.example.kexamplematerialmvvmfragments.ui.fragments_demo_rv.ItemTouchHelperAdapter
import com.example.kexamplematerialmvvmfragments.ui.fragments_demo_rv.ItemTouchHelperViewHolder
import com.example.kexamplematerialmvvmfragments.ui.fragments_demo_rv.MyBaseViewHolder
import kotlinx.android.synthetic.main.item_rv_small_simple.view.tv_description
import kotlinx.android.synthetic.main.item_rv_small.view.tv_title


class RVAdapter4 (fragmentContext: Context) : RecyclerView.Adapter<MyBaseViewHolder>(), ItemTouchHelperAdapter {

    companion object {
        private const val TYPE_SMALL = 1
        private const val TYPE_MEDIUM = 2
    }

    val aContext: Context = fragmentContext

    // не путать set с конструктором
    var aListPair: MutableList<Pair<NoteDemoRV, Boolean>> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    // ----------------------------------------------------------------
    // ВАРИАНТ №2. Базовый холдер - вынесенный в отдельный класс (файл)
    // ----------------------------------------------------------------

    // Первый ViewHolder
    inner class SmallViewHolder(itemView: View) : MyBaseViewHolder(itemView), ItemTouchHelperViewHolder {
        // "находим" (для kotlin) нужные вьюшки и связываем их
        override fun bind(onlyOnePair: Pair<NoteDemoRV, Boolean>) {
            itemView.tv_title.text = onlyOnePair.first.mTitle
//            itemView.tv_id.text = onlyOnePair.second.toString()
//            itemView.tv_description.text = onlyOnePair.first.mDescription


        }

        override fun onItemSelected() {
            itemView.setBackgroundColor(234345)
        }

        override fun onItemClear() {
            itemView.setBackgroundColor(0)
        }
    }

    // ВТОРОЙ ViewHolder
    inner class MediumViewHolder(itemView: View) : MyBaseViewHolder(itemView) {
        // "находим" (для kotlin) нужные вьюшки и связываем их
        override fun bind(onlyOnePair: Pair<NoteDemoRV, Boolean>) {
            itemView.tv_title.text = onlyOnePair.first.mTitle
            itemView.tv_description.text = onlyOnePair.first.mDescription

        }
    }


    // Метод имеет тип - не конкретный, а общий холдер  -": RecyclerView.ViewHolder"
    // но возвращает конкретный в зависимости от определенного типа Note
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyBaseViewHolder {
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

    // Передать строчку из arrayList во vh через метод bind
    override fun onBindViewHolder(holder: MyBaseViewHolder, position: Int) {
        // учитывая использование Базового холдера, здесь достаточно вызвать абстрактный метод,
        // конкретная реализация уже будет описана конкретным холдером
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


    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        aListPair.removeAt(fromPosition).apply {
            aListPair.add(if (toPosition > fromPosition) toPosition - 1 else toPosition, this)
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onItemDismiss(position: Int) {
        aListPair.removeAt(position)
        notifyItemRemoved(position)
    }
}
