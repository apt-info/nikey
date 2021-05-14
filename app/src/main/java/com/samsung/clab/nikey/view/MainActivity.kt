package com.samsung.clab.nikey.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.samsung.clab.nikey.R
import com.samsung.clab.nikey.databinding.ActivityMainBinding
import com.samsung.clab.nikey.model.Scenario
import com.samsung.clab.nikey.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.viewModel = viewModel
        initViewModel(viewModel)
    }

    private fun initViewModel(viewModel: MainViewModel) {
        initScenarioObserver(viewModel)
    }

    private fun initScenarioObserver(viewModel: MainViewModel) {
        viewModel.scenarioData.observe(this) {
            when (it) {
                Scenario.NAVER -> { startActivity(NaverActivity::class.java) }
                Scenario.KAKAOTALK -> { startActivity(KatalkActivity::class.java) }
                else -> {}
            }
        }
    }

    private fun startActivity(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }
}