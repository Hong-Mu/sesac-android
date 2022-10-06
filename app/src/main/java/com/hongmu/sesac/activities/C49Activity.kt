package com.hongmu.sesac.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hongmu.sesac.databinding.ActivityC49Binding
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class C49Activity : AppCompatActivity() {

    private val binding by lazy { ActivityC49Binding.inflate(layoutInflater) }
    val backGroundScope = CoroutineScope(Dispatchers.Default + Job())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            backGroundScope.launch {
                var sum = 0L
                var time = measureTimeMillis {
                    for(i in 1..2_000_000_000){
                        sum += i
                    }
                }
                withContext(Dispatchers.Main){ // Context Switching
                    binding.resultView.text = "sum: $sum"
                }
            }
        }

    }
}