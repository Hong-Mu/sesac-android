package com.hongmu.sesac.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hongmu.sesac.database.DBHelper
import com.hongmu.sesac.databinding.ActivityC60SubBinding

class C60SubActivity : AppCompatActivity() {

    private val binding by lazy { ActivityC60SubBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val db = DBHelper(this).readableDatabase
        val cursor = db.rawQuery("SELECT title, content FROM tb_memo ORDER BY _id DESC", null)
        while(cursor.moveToNext()){
            binding.textMemo.text = binding.textMemo.text.toString() + cursor.getString(0) + '\n' + cursor.getString(1) + "\n\n"
        }
        db.close()
    }
}