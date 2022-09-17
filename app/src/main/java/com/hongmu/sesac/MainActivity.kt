package com.hongmu.sesac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hongmu.sesac.activities.C11Activity
import com.hongmu.sesac.activities.C12Activity
import com.hongmu.sesac.activities.C13Activity
import com.hongmu.sesac.activities.C14Activity
import com.hongmu.sesac.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.adapter = ActivityAdapter(listOf(
            C14Activity::class.java,
            C13Activity::class.java,
            C12Activity::class.java,
            C11Activity::class.java,
        ))
    }
}