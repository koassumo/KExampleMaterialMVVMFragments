package com.example.kexamplematerialmvvmfragments.ui.fragments_demo_rv.demorv4

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.kexamplematerialmvvmfragments.ui.fragments_demo_rv.ItemTouchHelperViewHolder
import com.example.kexamplematerialmvvmfragments.ui.fragments_demo_rv.demorv4.RVAdapter4

class ItemTouchHelperCallback (private val adapter: RVAdapter4): ItemTouchHelper.Callback () {


// Обязательные методы
    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
    val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
    val swipeFlags = ItemTouchHelper.START or ItemTouchHelper.END
    return makeMovementFlags(
        dragFlags,
        swipeFlags)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        adapter.onItemMove(viewHolder.adapterPosition, target.adapterPosition)
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        adapter.onItemDismiss(viewHolder.adapterPosition)
    }

// Иные методы

    override fun isLongPressDragEnabled(): Boolean {
        return true
    }

    // В качестве альтернативы можно использовать ItemTouchHelper.startSwipe(RecyclerView.ViewHolder) для большего контроля
    override fun isItemViewSwipeEnabled(): Boolean {
        return true
    }

// Еще иные
    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            val itemViewHolder = viewHolder as ItemTouchHelperViewHolder
            itemViewHolder.onItemSelected()
        }
        super.onSelectedChanged(viewHolder, actionState)
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        super.clearView(recyclerView, viewHolder)
        val itemViewHolder = viewHolder as ItemTouchHelperViewHolder
        itemViewHolder.onItemClear()
    }
}


