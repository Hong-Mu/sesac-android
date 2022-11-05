package com.hongmu.sesac.activities

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.hongmu.sesac.R
import com.hongmu.sesac.database.DBHelper

class C59Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c59)

        findViewById<Button>(R.id.btnSelect).setOnClickListener {
            val db: SQLiteDatabase = DBHelper(this).readableDatabase
            val cursor = db.rawQuery("SELECT name FROM tb_member", null)
            if(cursor.moveToFirst()){
                Toast.makeText(this, "${cursor.getString(0)}", Toast.LENGTH_SHORT).show()
            }
            db.close()
        }
    }
}