package com.hongmu.sesac.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.hongmu.sesac.R

class C41Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c41)

        val list = listOf(
            "android", "kotlin", "jetpack", "java", "react", "flutter",
            "android", "kotlin", "jetpack", "java", "react", "flutter",
            "android", "kotlin", "jetpack", "java", "react", "flutter",
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)

        val listView = findViewById<ListView?>(R.id.listView).also { it.adapter = adapter }
        listView.setOnItemClickListener { adapterView, view, i, l ->
            startActivity(Intent(this, C41SubActivity::class.java).apply {
                putExtra("id", i)
                putExtra("title", list[i])
            })
        }
    }
}