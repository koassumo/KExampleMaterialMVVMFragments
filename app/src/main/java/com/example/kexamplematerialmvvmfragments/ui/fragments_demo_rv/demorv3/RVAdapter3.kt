package com.example.kexamplematerialmvvmfragments.ui.fragments_demo_rv.demorv3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kexamplematerialmvvmfragments.R
import com.example.kexamplematerialmvvmfragments.model.entity.NoteDemoRV



class RVAdapter3 (fragmentContext: Context): RecyclerView.Adapter<RVAdapter3.BaseViewHolder>() {

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

    // ВАРИАНТ №2. Базовый холдер
    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(onlyOneNote: NoteDemoRV)
    }

    // Первый ViewHolder
    inner class SmallViewHolder(itemView: View) : BaseViewHolder(itemView) {
        private val tv_title = itemView.findViewById<TextView>(R.id.tv_title)
        private val tv_id = itemView.findViewById<TextView>(R.id.tv_id)
        private val tv_description = itemView.findViewById<TextView>(R.id.tv_description)
        override fun bind(onlyOneNote: NoteDemoRV) {

            tv_title.text = onlyOneNote.mTitle
            tv_id.text = onlyOneNote.mId
            tv_description.text = onlyOneNote.mDescription

            itemView.setOnClickListener {
                Toast.makeText(aContext, "layoutPosition: $layoutPosition", Toast.LENGTH_SHORT).show()
            }
        }

        private fun addItem() {
            aListNoteDemos.add(layoutPosition, generateItem())
            notifyItemInserted(layoutPosition)
        }

        private fun removeItem() {
            aListNoteDemos.removeAt(layoutPosition)
            notifyDataSetChanged()
        }

    }



    // ВТОРОЙ ViewHolder
    inner class MediumViewHolder(itemView: View) : BaseViewHolder(itemView) {
        private val tv_title = itemView.findViewById<TextView>(R.id.tv_title)
        private val tv_id = itemView.findViewById<TextView>(R.id.tv_id)
        private val tv_description = itemView.findViewById<TextView>(R.id.tv_description)


        override fun bind(onlyOneNote: NoteDemoRV) {
            tv_title.text = onlyOneNote.mTitle
            tv_id.text = onlyOneNote.mId
            tv_description.text = onlyOneNote.mDescription

            itemView.findViewById<ImageView>(R.id.iv_add_item).setOnClickListener { addItem() }
            itemView.findViewById<ImageView>(R.id.iv_remove_item).setOnClickListener { removeItem() }
            itemView.findViewById<ImageView>(R.id.iv_downward_item).setOnClickListener { moveDown() }
            itemView.findViewById<ImageView>(R.id.iv_upward_item).setOnClickListener { moveUp() }
        }

        private fun addItem() {
            aListNoteDemos.add(layoutPosition, generateItem())
            notifyItemInserted(layoutPosition)
        }

        private fun removeItem() {
            aListNoteDemos.removeAt(layoutPosition)
            notifyItemRemoved(layoutPosition)
        }


        private fun moveUp() {
            if (layoutPosition < 1) return
            aListNoteDemos.add(layoutPosition - 1, aListNoteDemos [layoutPosition])
            aListNoteDemos.removeAt(layoutPosition + 1)
            notifyItemMoved(layoutPosition, layoutPosition - 1)
//          Вариант из урока (kotlin style):
//            layoutPosition.takeIf { it > 1 }?.also { currentPosition ->
//                aListNoteDemos.removeAt(currentPosition).apply {
//                    aListNoteDemos.add(currentPosition - 1, this)
//                }
//                notifyItemMoved(currentPosition, currentPosition - 1)
//            }
        }

        private fun moveDown() {
            if (layoutPosition > aListNoteDemos.size - 2) return
            aListNoteDemos.add(layoutPosition + 2, aListNoteDemos [layoutPosition])
            aListNoteDemos.removeAt(layoutPosition)
            notifyItemMoved(layoutPosition, layoutPosition + 1)
//          Вариант из урока (kotlin style):
//            layoutPosition.takeIf { it < aListNoteDemos.size - 1 }?.also { currentPosition ->
//                aListNoteDemos.removeAt(currentPosition).apply {
//                    aListNoteDemos.add(currentPosition + 1, this)
//                }
//                notifyItemMoved(currentPosition, currentPosition + 1)
//            }
        }

    }

    // Третий ViewHolder (для TYPE_HEADERS)
    inner class HeadersViewHolder(itemView: View) : BaseViewHolder (itemView) {
        // "находим" (для kotlin) нужные вьюшки и связываем их
        override fun bind(onlyOneNote: NoteDemoRV) {
            itemView.findViewById<TextView>(R.id.tv_title).text = onlyOneNote.mTitle
        }

        private fun addItem() {
            aListNoteDemos.add(layoutPosition, generateItem())
            notifyItemInserted(layoutPosition)
        }

        private fun removeItem() {
            aListNoteDemos.removeAt(layoutPosition)
            notifyDataSetChanged()
        }
    }


    // Метод имеет тип - не конкретный, а общий холдер  -": RecyclerView.ViewHolder"
    // но возвращает конкретный в зависимости от определенного типа Note
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val myInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_HEADER -> HeadersViewHolder(myInflater.inflate(R.layout.item_rv_header, parent, false))
            TYPE_SMALL -> SmallViewHolder(myInflater.inflate(R.layout.item_rv_small, parent, false))
            else -> MediumViewHolder(myInflater.inflate(R.layout.item_rv_medium, parent, false))
        }
    }

    // Метод получает как общий холдер, и определяет его конкретный вид через as
    // Передать строчку из arrayList во vh через метод bind
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(aListNoteDemos[position])
    }

    // 3. из кода эта функция не вызывается
    override fun getItemCount(): Int {
        return aListNoteDemos.size
    }

    // определяем тип конкретного Note на основе его полей и позиции
    override fun getItemViewType(position: Int): Int {
        return when {
//            position == 0 -> TYPE_HEADER
            aListNoteDemos[position].mId.isNullOrBlank() -> TYPE_HEADER
            aListNoteDemos[position].mDescription.isNullOrBlank() -> TYPE_SMALL
            else -> TYPE_MEDIUM
        }
    }

    fun appendItem() {
        aListNoteDemos.add(1, generateItem())
        notifyItemInserted(1)
        // notifyDataSetChanged()
    }

    private fun generateItem(): NoteDemoRV = NoteDemoRV("New Item", "New Item","New Item")


}