package com.samsung.clab.nikey.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.samsung.clab.nikey.model.Scenario

class MainViewModel : ViewModel() {

    val scenarioData = MutableLiveData<Scenario>()

    fun onClicked(scenario: Scenario) {
        scenarioData.postValue(scenario)
    }
}