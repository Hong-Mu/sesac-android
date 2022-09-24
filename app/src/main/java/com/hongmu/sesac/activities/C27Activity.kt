package com.hongmu.sesac.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hongmu.sesac.databinding.ActivityC27Binding

class C27Activity : AppCompatActivity() {

    private val binding by lazy { ActivityC27Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}