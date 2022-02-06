package com.triare.p121quakealert.data.repository

import android.util.Log
import com.triare.p121quakealert.data.api.BASE_URL
import com.triare.p121quakealert.data.api.QuakeAlertService
import com.triare.p121quakealert.data.mapper.QuakeAlertMapper
import com.triare.p121quakealert.data.model.QuakeAlertDto
import com.triare.p121quakealert.ui.model.QuakeAlertDvo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuakeAlertRepository {

    fun getQuakeAlert(result: (QuakeAlertDvo) -> Unit) {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val quakeAlertService = retrofit.create(QuakeAlertService::class.java)

        quakeAlertService.getQuakeAlert(3)
            .enqueue(object : Callback<QuakeAlertDto> {
                override fun onResponse(
                    call: Call<QuakeAlertDto>,
                    response: Response<QuakeAlertDto>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let { result(QuakeAlertMapper(it).map()) }
                    } else {
                        Log.d("Error", response.code().toString())
                    }
                }

                override fun onFailure(call: Call<QuakeAlertDto>, t: Throwable) {
                    Log.d("Error", "Error Quake Alert")
                    t.printStackTrace()
                }
            })
    }
}