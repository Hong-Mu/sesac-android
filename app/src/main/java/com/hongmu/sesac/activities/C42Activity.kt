package com.hongmu.sesac.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.hongmu.sesac.R
import com.hongmu.sesac.databinding.ActivityC42Binding

class C42Activity : AppCompatActivity() {

    private val binding by lazy { ActivityC42Binding.inflate(layoutInflater) }

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        val result = it.data?.getStringExtra("result")
        binding.textResult.text = "launcher: $result"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnStartActivityForResult.setOnClickListener {
            startActivityForResult(Intent(this, C42SubActivity::class.java).apply {
                putExtra("id", 1)
            }, 10)
        }

        binding.btnLauncher.setOnClickListener {
            launcher.launch(Intent(this, C42SubActivity::class.java).apply {
                putExtra("id", 2)
            })
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 10 && resultCode == RESULT_OK){
            val result = data?.getStringExtra("result")
            binding.textResult.text = "onActivityResult: $result"
        }

    }
}