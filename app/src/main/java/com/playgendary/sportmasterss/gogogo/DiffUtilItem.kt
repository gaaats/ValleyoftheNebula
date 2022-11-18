package com.playgendary.sportmasterss.gogogo

import androidx.recyclerview.widget.DiffUtil

class DiffUtilItem : DiffUtil.ItemCallback<SlotElement>() {
    override fun areItemsTheSame(oldItem: SlotElement, newItem: SlotElement): Boolean {
        return oldItem.edfrtgt == oldItem.edfrtgt
    }

    override fun areContentsTheSame(oldItem: SlotElement, newItem: SlotElement): Boolean {
        return oldItem == oldItem
    }
}