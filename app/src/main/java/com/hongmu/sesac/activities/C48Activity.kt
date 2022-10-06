package com.hongmu.sesac.activities

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import com.hongmu.sesac.databinding.ActivityC47Binding

class C48Activity : AppCompatActivity() {

    private val binding by lazy { ActivityC47Binding.inflate(layoutInflater) }

    var isFirst = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.mainStartBtn.setOnClickListener {
            if(isFirst){
                myAsyncTask.isRun = true
                myAsyncTask.execute()
                isFirst = false
            } else {
                myAsyncTask.isRun = true
            }

        }

        binding.mainPauseBtn.setOnClickListener {
            myAsyncTask.isRun = false
        }
    }
    private val myAsyncTask by lazy {
        object : AsyncTask<Unit, Int?, String>() {
            var loopFlag = true
            var isRun = false

            override fun doInBackground(vararg p0: Unit): String {
                var count = 10
                while (loopFlag) {
                    SystemClock.sleep(1000)
                    if (isRun) {
                        count--
                        publishProgress(count)
                        if (count == 0) {
                            loopFlag = false
                        }
                    }
                }
                return "Finish!"
            }

            override fun onProgressUpdate(vararg values: Int?) {
                super.onProgressUpdate(*values)
                binding.mainTextView.text = values[0].toString()
            }

            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)
                binding.mainTextView.text = result
            }
        }
    }
}