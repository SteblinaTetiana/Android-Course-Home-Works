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

        val country = Country("Afghanistan", afghanistan.setCompoundDrawables(null, null,
            getDrawable( R.drawable.afghanistan),null).hashCode())
        val country1 = Country("Albania", albania.setCompoundDrawables(null, null,
            getDrawable( R.drawable.albania),null).hashCode())
        val country2 = Country("Algeria", algeria.setCompoundDrawables(null, null,
            getDrawable( R.drawable.algeria),null).hashCode())
        val country3 = Country("Andorra",andorra.setCompoundDrawables(null, null,
            getDrawable( R.drawable.andorra),null).hashCode())

        afghanistan.setOnClickListener {
             setResult(REQUEST_COUNTRY, Intent().putExtra("COUNTRY", country))
            finish()
        }
        albania.setOnClickListener {
            setResult(REQUEST_COUNTRY, Intent().putExtra("COUNTRY", country1))
            finish()
        }
        algeria.setOnClickListener {
            setResult(REQUEST_COUNTRY, Intent().putExtra("COUNTRY", country2))
            finish()
        }
        andorra.setOnClickListener {
            setResult(REQUEST_COUNTRY, Intent().putExtra("COUNTRY", country3))
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

