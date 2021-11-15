package com.triare.p081userprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import kotlinx.parcelize.Parcelize


class CountryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)

        val afghanistan = findViewById<Button>(R.id.afghanistan)
        val albania = findViewById<Button>(R.id.albania)
        val algeria = findViewById<Button>(R.id.algeria)
        val andorra = findViewById<Button>(R.id.andorra)
        val country = Country("Afghanistan", R.drawable.afghanistan.toString())
        val country1 = Country("Albania", R.drawable.albania.toString())
        val country2 = Country("Algeria", R.drawable.algeria.toString())
        val country3 = Country("Andorra", R.drawable.andorra.toString())

        supportActionBar?.title = "Country"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        afghanistan.setOnClickListener {
             setResult(3, Intent().putExtra("COUNTRY", country))
            finish()
        }
        albania.setOnClickListener {
            setResult(3, Intent().putExtra("COUNTRY", country1))
            finish()
        }
        algeria.setOnClickListener {
            setResult(3, Intent().putExtra("COUNTRY", country2))
            finish()
        }
        andorra.setOnClickListener {
            setResult(3, Intent().putExtra("COUNTRY", country3))
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    @Parcelize
    data class Country(val title: String?, val image: String?):Parcelable
}

