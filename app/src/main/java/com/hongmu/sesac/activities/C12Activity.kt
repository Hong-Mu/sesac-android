package com.hongmu.sesac.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.hongmu.sesac.R

class C12Activity : AppCompatActivity() {

    private lateinit var btnVisible: Button
    private lateinit var logo: ImageView
    private lateinit var btnInvisible: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c12)

        btnVisible = findViewById(R.id.btnVisible)
        logo = findViewById(R.id.logo)
        btnInvisible = findViewById(R.id.btnInvisible)

        btnVisible.setOnClickListener {
            logo.visibility = View.VISIBLE
        }

        btnInvisible.setOnClickListener {
            logo.visibility = View.INVISIBLE
        }
    }
}