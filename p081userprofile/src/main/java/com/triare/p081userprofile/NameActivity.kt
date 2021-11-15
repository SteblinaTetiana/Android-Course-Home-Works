package com.triare.p081userprofile

import android.app.ActionBar
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class NameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        val name = findViewById<EditText>(R.id.name).text
        val save_button = findViewById<Button>(R.id.button_save)


        supportActionBar?.title = "Name"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        save_button.setOnClickListener {
            setResult(1, Intent().putExtra("NAME", name.toString()))
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
