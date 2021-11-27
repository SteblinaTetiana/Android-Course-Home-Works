package com.triare.p101recyclerviewchattutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = ChatAdapter(ChatStorage.random(this))


    }
}