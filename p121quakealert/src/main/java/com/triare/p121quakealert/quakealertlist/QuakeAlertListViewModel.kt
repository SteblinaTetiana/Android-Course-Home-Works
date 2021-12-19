package com.triare.p121quakealert.quakealertlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.triare.p121quakealert.api.QuakeAlertService
import com.triare.p121quakealert.model.QuakeAlert
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuakeAlertListViewModel : ViewModel() {

    private val _quakeAlertResult = MutableLiveData<QuakeAlert>()
    val quakeAlertResult: LiveData<QuakeAlert> = _quakeAlertResult

    init {
        getQuakeAlert()
    }

    private fun getQuakeAlert() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.geonet.org.nz")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val quakeAlertService = retrofit.create(QuakeAlertService::class.java)

        quakeAlertService.getQuakeAlert(3)
            .enqueue(object : Callback<QuakeAlert> {
                override fun onResponse(
                    call: Call<QuakeAlert>,
                    response: Response<QuakeAlert>
                ) {
                    if (response.isSuccessful) {
                        _quakeAlertResult.postValue(response.body())
                    } else {
                        Log.d("Error", response.code().toString())
                    }
                }

                override fun onFailure(call: Call<QuakeAlert>, t: Throwable) {
                    Log.d("Error", "Error Quake Alert")
                    t.printStackTrace()
                }
            })
    }
}