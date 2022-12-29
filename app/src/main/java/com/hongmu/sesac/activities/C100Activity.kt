package com.hongmu.sesac.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.hongmu.sesac.R
import com.hongmu.sesac.databinding.ActivityC100Binding
import com.hongmu.sesac.viewmodels.C100ViewModel

class C100Activity : AppCompatActivity() {

    private val binding by lazy { ActivityC100Binding.inflate(layoutInflater) }
    private val viewModel: C100ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            viewModel.calSum().observe(this){
                binding.textResult.text = it
            }
        }
    }
}