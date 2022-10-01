package com.hongmu.sesac.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.hongmu.sesac.R

class C43Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c43)

        findViewById<Button>(R.id.btnMove).setOnClickListener {
            val intent = Intent().apply {
                action = "ACTION_SUB"
                data = Uri.parse("http://naver.com")
            }
            startActivity(intent)
        }
    }
}