package com.triare.p101recyclerviewchattutorial

import android.content.Context
import com.slmyldz.random.Randoms
import kotlin.random.Random

object ChatStorage {

    fun random(context: Context) = MutableList(100) {
        Chat(
            it,
            Randoms.imageUrl(1024, 1024),
            DummyNameStorage.random(),
            Randoms.sentence(context),
            "10:45 PM",
            Random.nextBoolean()
        )
    }
}