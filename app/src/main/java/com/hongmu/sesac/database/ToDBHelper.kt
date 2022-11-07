package com.hongmu.sesac.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class TodoDBHelper(context: Context): SQLiteOpenHelper(context, "myDB", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("""CREATE TABLE TABLE_TODO (
            _id INTEGER PRIMARY KEY AUTOINCREMENT,
            todo
        )""")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int){

    }
}