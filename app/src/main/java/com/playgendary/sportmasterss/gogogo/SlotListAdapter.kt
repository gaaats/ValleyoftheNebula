package com.playgendary.sportmasterss.gogogo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.playgendary.sportmasterss.R
import com.playgendary.sportmasterss.databinding.SingleSlotElementBinding

class SlotListAdapter :
    ListAdapter<SlotElement, SlotListAdapter.SlotListVievHolder>(DiffUtilItem()) {


    class SlotListVievHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bindingdfrgtt = SingleSlotElementBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlotListVievHolder {
        LayoutInflater.from(parent.context)
            .inflate(R.layout.single_slot_element, parent, false).also {
                return SlotListVievHolder(it)
            }
    }

    override fun onBindViewHolder(holder: SlotListVievHolder, position: Int) {
        val rgyhyyhyh = getItem(position)
        holder.bindingdfrgtt.imgOnSingleItem.setImageResource(rgyhyyhyh.imagedfrgt)
    }
}

