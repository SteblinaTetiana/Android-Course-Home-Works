package com.triare.p081userprofile


import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.ACTION_IMAGE_CAPTURE
import android.widget.*
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import android.widget.ArrayAdapter
import kotlin.with as with1


class MainActivity : AppCompatActivity() {

    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result: ActivityResult ->
            when (result.resultCode) {
                2 -> {
                    findViewById<ImageView>(R.id.image_profile).setImageBitmap(result.data?.extras?.get("data") as Bitmap)
                }
                -1 -> {
                    findViewById<ImageView>(R.id.image_profile).setImageURI(result.data?.data)
                }
                1 -> {
                    findViewById<TextView>(R.id.textview_name).text =
                        result.data?.getStringExtra("NAME")
                }
                3 -> {
                    findViewById<TextView>(R.id.textview_country).text =
                        result.data?.getParcelableExtra<CountryActivity.Country>("COUNTRY").toString()
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val image_button = findViewById<ImageButton>(R.id.imageButton)
        val name = findViewById<TextView>(R.id.textview_name)
        val country = findViewById<TextView>(R.id.textview_country)
        name.setOnClickListener {
            val intent_name = Intent(this, NameActivity::class.java)
            startForResult.launch(intent_name)
        }

        country.setOnClickListener {
            val intent_country = Intent(this, CountryActivity::class.java)
            startForResult.launch(intent_country)
        }


        image_button.setOnClickListener {
            showMenu()
            val takePicture = Intent(ACTION_IMAGE_CAPTURE)
            val pickPhoto =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)

            startForResult.launch(takePicture)
            startForResult.launch(pickPhoto)
            }
    }

     private fun showMenu() {
        val image_button = findViewById<ImageButton>(R.id.imageButton)
        val text_item = findViewById<TextView>(R.id.text_item)
        val menu = ListPopupWindow(this)
        menu.anchorView = image_button

        val items = listOf("Camera", "Gallery")
        val adapter = ArrayAdapter(this, R.layout.listpopupwindow_item, items)
        menu.setAdapter(adapter)
        menu.setOnItemClickListener { parent, view, position, id ->
            text_item.text = items[position]
           /* if (items[position] == text_item.text) {
                val takePicture = Intent(ACTION_IMAGE_CAPTURE)
                startActivityForResult(takePicture, 2)
            } else if (items[position] == text_item.text) {
                val pickPhoto =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(pickPhoto, -1)*/
                menu.dismiss()
            }
            menu.show()
}
}

