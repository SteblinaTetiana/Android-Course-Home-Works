package com.triare.p091directorysviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private var viewModel:MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.image)
        val title = findViewById<TextView>(R.id.heading)
        val description = findViewById<TextView>(R.id.description)

       viewModel= ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel?.animalsModel?.observe(this){
            image.setImageResource(it.image!!)
            title.text = it.title
            description.text = it.description
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {

        val buttonAnimals=findViewById<RadioButton>(R.id.animals)
        val buttonPlants=findViewById<RadioButton>(R.id.plants)

        menu?.setGroupVisible(R.id.group_animals, buttonAnimals.isChecked)
        menu?.setGroupVisible(R.id.group_plants, buttonPlants.isChecked)

        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel?.addAnimals(item.itemId)
        return super.onOptionsItemSelected(item)
    }

}