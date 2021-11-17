package com.triare.p081userprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class NameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        val name = findViewById<EditText>(R.id.name).text
        val saveButton = findViewById<Button>(R.id.button_save)


        supportActionBar?.title = "Name"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        saveButton.setOnClickListener {
            setResult(REQUEST_NAME, Intent().putExtra("NAME", name.toString()))
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    companion object  {
        const val REQUEST_NAME = 1
    }
}
