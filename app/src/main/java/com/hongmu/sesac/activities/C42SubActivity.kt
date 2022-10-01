package com.hongmu.sesac.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hongmu.sesac.R
import com.hongmu.sesac.databinding.ActivityC42SubBinding

class C42SubActivity : AppCompatActivity() {

    private val binding by lazy { ActivityC42SubBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val id = intent.getIntExtra("id", 0)

        binding.btnFinish.setOnClickListener {
            intent.putExtra("result", "Hello $id")
            setResult(RESULT_CANCELED, intent)
            finish()
        }

    }
}