package com.samsung.clab.nikey.view.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.samsung.clab.nikey.viewModel.ItemViewModel

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("imageResource")
    fun bindImageResource(imageView: ImageView, src: Int) {
        imageView.setImageResource(src)
    }

    @JvmStatic
    @BindingAdapter("items")
    fun bindItems(recyclerView: RecyclerView, items: ArrayList<ItemViewModel>) {
        if (recyclerView.adapter != null) {
            (recyclerView.adapter as ItemAdapter).updateViewModel(items)
        } else {
            val adapter = ItemAdapter()
            recyclerView.adapter = adapter
            adapter.updateViewModel(items)
        }
    }
}