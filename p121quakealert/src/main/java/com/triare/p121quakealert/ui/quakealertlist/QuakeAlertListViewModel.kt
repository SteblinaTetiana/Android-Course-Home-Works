package com.triare.p121quakealert.ui.quakealertlist

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.triare.p121quakealert.data.repository.QuakeAlertRepository
import com.triare.p121quakealert.ui.model.FeatureDvo
import com.triare.p121quakealert.ui.model.QuakeAlertDvo

class QuakeAlertListViewModel : ViewModel() {

    private val _quakeAlertResult = MutableLiveData<QuakeAlertDvo>()
    val quakeAlertResult: LiveData<QuakeAlertDvo> = _quakeAlertResult

    private val quakeAlertRepository = QuakeAlertRepository()

    init {
        getQuakeAlert()
    }

    private fun getQuakeAlert() {
        quakeAlertRepository.getQuakeAlert {
            _quakeAlertResult.value = it
        }
    }

    fun list(view: View, feature: FeatureDvo) {
        QuakeAlertListFragmentDirections.actionQuakeAlertListFragmentToDetailFragment(
            feature
        ).also {
            view.findNavController().navigate(it)
        }
    }
}