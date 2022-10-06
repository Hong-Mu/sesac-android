package com.hongmu.sesac.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import com.hongmu.sesac.databinding.ActivityC47Binding

class C47Activity : AppCompatActivity() {

    private val binding by lazy { ActivityC47Binding.inflate(layoutInflater) }

    private var loopFlag = true
    private var isFirst = true
    private var isRun = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.mainStartBtn.setOnClickListener {
            if(isFirst){
                isFirst = false
                isRun = true
                thread.start()
            } else {
                isRun = true
            }
        }

        binding.mainPauseBtn.setOnClickListener {
            isRun = false
        }
    }

    private var handler = object : Handler(){
        override fun handleMessage(msg: Message) {
            if(msg.what === 1){
                binding.mainTextView.text = msg.arg1.toString()
            } else if(msg.what === 2){
                binding.mainTextView.text = msg.obj as String
            }
        }
    }

    var thread = Thread {
        try{
            var count = 10
            while(loopFlag){
                Thread.sleep(1000)
                if(isRun){
                    count--
                    handler.sendMessage(Message().apply {
                        what = 1
                        arg1 = count
                    })
                    if(count == 0){
                        handler.sendMessage(Message().apply {
                            what = 2
                            obj = "Finish!"
                        })
                        loopFlag = false
                    }
                }
            }
        } catch(e: Exception){

        }
    }
}