package com.samsung.clab.nikey.viewModel

import android.util.Log
import android.view.View
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel

class NaverViewModel: ViewModel() {

    val shoesVisible = ObservableInt(View.GONE)

    fun onClickShoes() {
        shoesVisible.set(View.VISIBLE)
    }
}
