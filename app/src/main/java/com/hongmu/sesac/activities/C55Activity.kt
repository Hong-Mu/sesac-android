package com.hongmu.sesac.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hongmu.sesac.databinding.ActivityC55Binding

class C55Activity : AppCompatActivity() {

    private val binding by lazy { ActivityC55Binding.inflate(layoutInflater) }
    private val pref by lazy { getSharedPreferences("PREF_APP", MODE_PRIVATE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            pref.edit()
                .putString("DATA_1", binding.editView.text.toString())
                .putBoolean("DATA_2", binding.checkView.isChecked)
                .apply()
        }

        binding.getButton.setOnClickListener {
            val data1 = pref.getString("DATA_1", "None")
            val data2 = pref.getBoolean("DATA_2", false)
            binding.resultView.text = "DATA1: $data1, DATA2: $data2"
        }
    }
}