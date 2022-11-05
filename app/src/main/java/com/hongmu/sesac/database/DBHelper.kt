package com.hongmu.sesac.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context): SQLiteOpenHelper(context, "myDB", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        // 테이블 생성 쿼리
        val createMemberTableSql = """
            CREATE TABLE tb_member (
                _id integer primary key autoincrement,
                name not null,
                email,
                phone
            ) 
        """
        db?.execSQL(createMemberTableSql)

        // 데이터 추가 쿼리 실행
        db?.execSQL("INSERT INTO tb_member (name, email, phone) VALUES ('Hong', 'hongmuchae@gmail.com', '01012345678')")

        val createMemoTableSql = """
            CREATE TABLE tb_memo (
                _id integer primary key autoincrement,
                title,
                content
            ) 
        """
        db?.execSQL(createMemoTableSql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE tb_member")
        onCreate(db)
    }
}