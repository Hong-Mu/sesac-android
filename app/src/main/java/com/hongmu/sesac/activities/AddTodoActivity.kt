package com.hongmu.sesac.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.hongmu.sesac.R
import com.hongmu.sesac.databinding.ActivityAddTodoBinding

class AddTodoActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddTodoBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_add_todo, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId){
        R.id.menuSave -> {
            intent.putExtra("todo", binding.inputTodo.text.toString())
            setResult(RESULT_OK, intent)
            finish()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}