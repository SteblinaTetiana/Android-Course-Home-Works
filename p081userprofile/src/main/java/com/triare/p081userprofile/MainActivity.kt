package com.triare.p081userprofile


import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.ACTION_IMAGE_CAPTURE
import android.util.Log
import android.widget.*
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import android.widget.ArrayAdapter








class MainActivity : AppCompatActivity() {

    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result: ActivityResult ->
            if (result.resultCode != Activity.RESULT_OK) {
            } else {
                try {
                    val selectedImage: Uri? = result.data?.data
                    if (selectedImage != null) {
                        findViewById<ImageView>(R.id.image_profile).setImageURI(result.data?.data)
                    } else {
                        findViewById<ImageView>(R.id.image_profile).setImageBitmap(result.data?.extras?.get(
                            "data") as Bitmap)
                    }
                } catch (error: Exception) {
                    Log.d("TAG==>>", "Error : ${error.localizedMessage}")
                }
            }

            when (result.resultCode) {
                NameActivity.REQUEST_NAME -> {
                    findViewById<TextView>(R.id.textview_name).text =
                        result.data?.getStringExtra("NAME")
                }
                CountryActivity.REQUEST_COUNTRY -> {
                    findViewById<TextView>(R.id.textview_country).text =
                        result.data?.getParcelableExtra<CountryActivity.Country>("COUNTRY").toString()
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val selectItem = findViewById<ImageButton>(R.id.select_item)
        val name = findViewById<TextView>(R.id.textview_name)
        val country = findViewById<TextView>(R.id.textview_country)
        name.setOnClickListener {
            val intentName = Intent(this, NameActivity::class.java)
            startForResult.launch(intentName)
        }

        country.setOnClickListener {
            val intentCountry = Intent(this, CountryActivity::class.java)
            startForResult.launch(intentCountry)
        }

        selectItem.setOnClickListener {
            showMenu()
            }
    }


     private fun showMenu() {
         val selectItem = findViewById<ImageButton>(R.id.select_item)
         val menu = ListPopupWindow(this)
         menu.anchorView = selectItem

         val items = listOf("Camera", "Gallery")
         val adapter = ArrayAdapter(this, R.layout.listpopupwindow_item, items)
         menu.setAdapter(adapter)
         menu.setOnItemClickListener { parent, view, position, id ->
             if(position == 0 ){
                 val takePicture = Intent(ACTION_IMAGE_CAPTURE)
                 startForResult.launch(takePicture)
             } else {
                 val pickPhoto =Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                 pickPhoto.type = "image/*"
                 startForResult.launch(pickPhoto)
             }
             menu.dismiss()
         }
             menu.show()
         }
     }

