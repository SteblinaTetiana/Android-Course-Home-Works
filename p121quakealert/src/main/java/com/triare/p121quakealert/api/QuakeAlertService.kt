package com.triare.p121quakealert.api

import com.triare.p121quakealert.model.QuakeAlert
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface QuakeAlertService {

    @GET("quake?")
    fun getQuakeAlert(
        @Query("MMI") MMI: Int,
    ): Call<QuakeAlert>
}