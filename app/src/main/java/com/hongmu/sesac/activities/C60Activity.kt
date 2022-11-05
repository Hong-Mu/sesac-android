package com.hongmu.sesac.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hongmu.sesac.database.DBHelper
import com.hongmu.sesac.databinding.ActivityC60Binding

class C60Activity : AppCompatActivity() {

    private val binding by lazy { ActivityC60Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            val title = binding.inputTitle.text.toString()
            val content = binding.inputContent.text.toString()

            val db = DBHelper(this).writableDatabase
            db.execSQL("INSERT INTO tb_memo (title, content) VALUES (?, ?)", arrayOf(title, content))
            db.close()

            startActivity(Intent(this, C60SubActivity::class.java))
        }
    }
}