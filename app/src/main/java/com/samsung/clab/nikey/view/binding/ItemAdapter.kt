package com.samsung.clab.nikey.view.binding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.samsung.clab.nikey.R
import com.samsung.clab.nikey.databinding.LayoutItemBinding
import com.samsung.clab.nikey.viewModel.ItemViewModel

class ItemAdapter : RecyclerView.Adapter<BindingViewHolder<LayoutItemBinding>>() {

    private val viewModels = ArrayList<ItemViewModel>()

    fun updateViewModel(newItems: ArrayList<ItemViewModel>) {
        this.viewModels.clear()
        this.viewModels.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingViewHolder<LayoutItemBinding> {
        return BindingViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BindingViewHolder<LayoutItemBinding>, position: Int) {
        holder.binding.viewModel = viewModels[position]
    }

    override fun getItemCount(): Int {
        return viewModels.size
    }
}