package com.hongmu.sesac.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.hongmu.sesac.R

class C41SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c41_sub)

        val id = intent.getIntExtra("id", 0)
        val title = intent.getStringExtra("title")

        findViewById<TextView>(R.id.textView).text = "id: $id, title: $title"
    }
}