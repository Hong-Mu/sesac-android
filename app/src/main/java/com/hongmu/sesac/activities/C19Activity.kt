package com.hongmu.sesac.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hongmu.sesac.R
import com.hongmu.sesac.databinding.ActivityC19Binding

class C19Activity : AppCompatActivity() {

    private val binding by lazy { ActivityC19Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnTab1.setOnClickListener {
            binding.textRed.visibility = View.VISIBLE
            binding.textGreen.visibility = View.INVISIBLE
        }

        binding.btnTab2.setOnClickListener {
            binding.textRed.visibility = View.INVISIBLE
            binding.textGreen.visibility = View.VISIBLE
        }
    }
}