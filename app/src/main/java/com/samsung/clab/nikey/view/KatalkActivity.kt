package com.samsung.clab.nikey.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.samsung.clab.nikey.R
import com.samsung.clab.nikey.databinding.ActivityKatalkBinding
import com.samsung.clab.nikey.viewModel.KatalkViewModel

class KatalkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityKatalkBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_katalk)
        binding.viewModel = ViewModelProvider(this)[KatalkViewModel::class.java]

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.recyclerView.layoutManager = layoutManager
    }
}