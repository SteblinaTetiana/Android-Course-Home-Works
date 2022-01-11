package com.triare.p081userprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import com.google.android.material.button.MaterialButton
import kotlinx.parcelize.Parcelize


class CountryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)

        supportActionBar?.title = "Country"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val afghanistan = findViewById<MaterialButton>(R.id.afghanistan)
        val albania = findViewById<MaterialButton>(R.id.albania)
        val algeria = findViewById<MaterialButton>(R.id.algeria)
        val andorra = findViewById<MaterialButton>(R.id.andorra)

        val countryAfghanistan = Country("Afghanistan", R.drawable.afghanistan)
        val countryAlbania = Country("Albania", R.drawable.albania)
        val countryAlgeria = Country("Algeria",  R.drawable.algeria)
        val countryAndorra = Country("Andorra", R.drawable.andorra)

        afghanistan.setOnClickListener {
             setResult(REQUEST_COUNTRY, Intent().putExtra("COUNTRY", countryAfghanistan))
            finish()
        }
        albania.setOnClickListener {
            setResult(REQUEST_COUNTRY, Intent().putExtra("COUNTRY", countryAlbania))
            finish()
        }
        algeria.setOnClickListener {
            setResult(REQUEST_COUNTRY, Intent().putExtra("COUNTRY", countryAlgeria))
            finish()
        }
        andorra.setOnClickListener {
            setResult(REQUEST_COUNTRY, Intent().putExtra("COUNTRY", countryAndorra))
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    @Parcelize
    data class Country(val title: String, val image: Int):Parcelable


companion object  {
    const val REQUEST_COUNTRY = 3
}
}