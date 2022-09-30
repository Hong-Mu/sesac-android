package com.hongmu.sesac.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.hongmu.sesac.R

class C37Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c37)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add(0, 0, 0, "menu1") // groupId, itemId, order, title
        menu.add(0, 1, 0, "menu2") // groupId, itemId, order, title
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId){
        0 -> {
            Toast.makeText(this, "Menu 1", Toast.LENGTH_SHORT).show()
            true
        }
        1 -> {
            Toast.makeText(this, "Menu 2", Toast.LENGTH_SHORT).show()
            true
        }
         else -> super.onOptionsItemSelected(item)
    }
}