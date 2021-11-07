package com.triare.p071directorys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {

        val radio1=findViewById<RadioButton>(R.id.animals)
        val radio2=findViewById<RadioButton>(R.id.plants)

        menu?.setGroupVisible(R.id.group_animals, radio1.isChecked)
        menu?.setGroupVisible(R.id.group_plants, radio2.isChecked)

        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val image = findViewById<ImageView>(R.id.image)
        val heading = findViewById<TextView>(R.id.heading)
        val description = findViewById<TextView>(R.id.description)

        image.setImageDrawable(resources.getDrawable(R.drawable.sparrow, theme))
        heading.setText(R.string.sparrow)
        description.setText(R.string.description_sparrow)

        return super.onOptionsItemSelected(item)
    }

}