package com.hongmu.sesac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hongmu.sesac.activities.*
import com.hongmu.sesac.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.adapter = ActivityAdapter(listOf(
            CallKeypadActivity::class.java,
            KakaoConfirmPasswordActivity::class.java,
            C21Activity::class.java,
            C20Activity::class.java,
            C19Activity::class.java,
            C18Activity::class.java,
            C16Activity::class.java,
            C15Activity::class.java,
            C14Activity::class.java,
            C13Activity::class.java,
            C12Activity::class.java,
            C11Activity::class.java,
        ))
    }
}