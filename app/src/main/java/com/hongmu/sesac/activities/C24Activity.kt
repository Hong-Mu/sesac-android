package com.hongmu.sesac.activities

import android.os.Bundle
import android.view.MotionEvent
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet.Motion
import com.hongmu.sesac.R

class C24Activity : AppCompatActivity() {

    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c24)
        textResult = findViewById(R.id.textResult)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val eventType = when(event?.action){
            MotionEvent.ACTION_DOWN -> "DOWN"
            MotionEvent.ACTION_MOVE -> "MOVE"
            MotionEvent.ACTION_UP -> "UP"
            else -> ""
        }
        textResult.text = "$eventType : x - ${event?.x}, y - ${event?.y}"
        return super.onTouchEvent(event)

    }
}