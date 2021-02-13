package com.example.gymkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.gymkotlin.adapter.Constants

class InfoActivity : AppCompatActivity() {

    var textInfo: TextView? = null
    var imageInfo: ImageView? = null
    private lateinit var text: String
    private var image: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        init()
    }

    private fun init() {
        textInfo = findViewById(R.id.textInfo)
        imageInfo = findViewById(R.id.imageInfo)
        text = intent.getStringExtra(Constants.TEXT).toString()
        image = intent.getIntExtra(Constants.IMAGE, 0)
        textInfo?.text = text
        imageInfo?.setImageResource(image)
    }
}