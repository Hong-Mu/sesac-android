package com.hongmu.sesac.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import com.hongmu.sesac.R
import com.hongmu.sesac.databinding.ActivityC28Binding

class C28Activity : AppCompatActivity() {

    private val binding by lazy { ActivityC28Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.text1.apply {
            text = getString(R.string.world)
            setTextColor(ResourcesCompat.getColor(resources, R.color.text_color, null))
            textSize = resources.getDimension(R.dimen.text_size)
        }

    }
}