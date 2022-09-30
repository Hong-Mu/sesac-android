package com.hongmu.sesac.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
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

        binding.spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(this@C35Activity, binding.spinner.selectedItem.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        val data2 = arrayOf("apply", "apple", "below")
        val adapter2 = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            data2
        )
        binding.autoText.setAdapter(adapter2)
    }
}