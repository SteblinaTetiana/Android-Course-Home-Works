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

        val button_animals=findViewById<RadioButton>(R.id.animals)
        val button_plants=findViewById<RadioButton>(R.id.plants)

        menu?.setGroupVisible(R.id.group_animals, button_animals.isChecked)
        menu?.setGroupVisible(R.id.group_plants, button_plants.isChecked)

        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val image = findViewById<ImageView>(R.id.image)
        val heading = findViewById<TextView>(R.id.heading)
        val description = findViewById<TextView>(R.id.description)

        return when (item.itemId) {
            R.id.sparrow -> {
                image.setImageResource(R.drawable.sparrow)
                heading.setText(resources.getString(R.string.sparrow))
                description.setText(R.string.description_sparrow)
                true
            }
            R.id.oriole -> {
                image.setImageDrawable(resources.getDrawable(R.drawable.oriole, theme))
                heading.setText(R.string.oriole)
                description.setText(R.string.description_oriole)
                true
            }
            R.id.magpie -> {
                image.setImageDrawable(resources.getDrawable(R.drawable.magpie, theme))
                heading.setText(R.string.magpie)
                description.setText(R.string.description_magpie)
                true
            }
            R.id.squirrel -> {
                image.setImageDrawable(resources.getDrawable(R.drawable.squirrel, theme))
                heading.setText(R.string.squirrel)
                description.setText(R.string.description_squirrel)
                true
            }
            R.id.bear -> {
                image.setImageDrawable(resources.getDrawable(R.drawable.bear, theme))
                heading.setText(R.string.bear)
                description.setText(R.string.description_bear)
                true
            }
            R.id.fox -> {
                image.setImageDrawable(resources.getDrawable(R.drawable.fox, theme))
                heading.setText(R.string.fox)
                description.setText(R.string.description_fox)
                true
            }
            R.id.toad -> {
                image.setImageDrawable(resources.getDrawable(R.drawable.toad, theme))
                heading.setText(R.string.toad)
                description.setText(R.string.description_toad)
                true
            }
            R.id.salamander -> {
                image.setImageDrawable(resources.getDrawable(R.drawable.salamander, theme))
                heading.setText(R.string.salamander)
                description.setText(R.string.description_salamander)
                true
            }
            R.id.newt -> {
                image.setImageDrawable(resources.getDrawable(R.drawable.newts, theme))
                heading.setText(R.string.newt)
                description.setText(R.string.description_newt)
                true
            }
            R.id.oak -> {
                image.setImageDrawable(resources.getDrawable(R.drawable.oak, theme))
                heading.setText(R.string.oak)
                description.setText(R.string.description_oak)
                true
            }
            R.id.birch -> {
                image.setImageDrawable(resources.getDrawable(R.drawable.birch, theme))
                heading.setText(R.string.birch)
                description.setText(R.string.description_birch)
                true
            }
            R.id.pine -> {
                image.setImageDrawable(resources.getDrawable(R.drawable.pine, theme))
                heading.setText(R.string.pine)
                description.setText(R.string.description_pine)
                true
            }
            R.id.rose -> {
                image.setImageDrawable(resources.getDrawable(R.drawable.rose, theme))
                heading.setText(R.string.rose)
                description.setText(R.string.description_rose)
                true
            }
            R.id.lilies -> {
                image.setImageDrawable(resources.getDrawable(R.drawable.lilies, theme))
                heading.setText(R.string.lilies)
                description.setText(R.string.description_lilies)
                true
            }
            R.id.chrysanthemum -> {
                image.setImageDrawable(resources.getDrawable(R.drawable.chrysanthemum, theme))
                heading.setText(R.string.chrysanthemum)
                description.setText(R.string.description_chrysanthemum)
                true
            }
            R.id.rosehip -> {
                image.setImageDrawable(resources.getDrawable(R.drawable.rosehip, theme))
                heading.setText(R.string.rosehip)
                description.setText(R.string.description_rosehip)
                true
            }
            R.id.raspberries -> {
                image.setImageDrawable(resources.getDrawable(R.drawable.raspberries, theme))
                heading.setText(R.string.raspberries)
                description.setText(R.string.description_raspberries)
                true
            }
            R.id.lilac -> {
                image.setImageDrawable(resources.getDrawable(R.drawable.lilac, theme))
                heading.setText(R.string.lilac)
                description.setText(R.string.description_lilac)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}