package com.hongmu.sesac.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.hongmu.sesac.R

class C40Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c40)

        findViewById<Button>(R.id.btnMove).setOnClickListener {
            startActivity(Intent(this, C40SubActivity::class.java))
        }
    }
}