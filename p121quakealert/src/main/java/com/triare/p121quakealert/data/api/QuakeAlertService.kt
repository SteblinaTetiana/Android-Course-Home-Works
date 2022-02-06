package com.triare.p121quakealert.data.api

import com.triare.p121quakealert.data.model.QuakeAlertDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface QuakeAlertService {

    @GET("quake?")
    fun getQuakeAlert(
        @Query("MMI") MMI: Int,
    ): Call<QuakeAlertDto>
}