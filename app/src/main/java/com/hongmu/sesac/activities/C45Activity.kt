package com.hongmu.sesac.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hongmu.sesac.databinding.ActivityC45Binding

class C45Activity : AppCompatActivity() {

    private val binding by lazy { ActivityC45Binding.inflate(layoutInflater) }

    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnUp.setOnClickListener {
            count++
            binding.textCount.text = count.toString()
        }
        count = savedInstanceState?.getInt("count", 0)?:0
        binding.textCount.text = count.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
        outState.putString("edit", binding.inputText.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        binding.inputText.setText(savedInstanceState.getString("edit"))
    }
}