package com.hongmu.sesac.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.hongmu.sesac.R
import com.hongmu.sesac.databinding.ActivityC35Binding

class C35Activity : AppCompatActivity() {

    private val binding by lazy { ActivityC35Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val data = resources.getStringArray(R.array.language)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            data
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter

        val data2 = arrayOf("apply", "apple", "below")
        val adapter2 = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            data2
        )
        binding.autoText.setAdapter(adapter2)
    }
}