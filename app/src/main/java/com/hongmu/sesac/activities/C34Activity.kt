package com.hongmu.sesac.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.hongmu.sesac.R
import com.hongmu.sesac.adapters.C34Adapter
import com.hongmu.sesac.models.C34Model

class C34Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c34)

        val mutableList = mutableListOf<C34Model>()
        mutableList.add(C34Model("안드로이드", "2월 16일", "doc"))
        mutableList.add(C34Model("db.zip", "2월 16일", "file"))
        mutableList.add(C34Model("이미지", "2월 16일", "img"))

        val listView = findViewById<ListView>(R.id.listView)
        val adapter = C34Adapter(this, R.layout.item_c34, mutableList)
        listView.adapter = adapter
    }
}