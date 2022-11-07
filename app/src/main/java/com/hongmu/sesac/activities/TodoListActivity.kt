package com.hongmu.sesac.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import com.hongmu.sesac.adapters.TodoAdapter
import com.hongmu.sesac.database.TodoDBHelper
import com.hongmu.sesac.databinding.ActivityTodoListBinding

class TodoListActivity : AppCompatActivity() {

    private val binding by lazy { ActivityTodoListBinding.inflate(layoutInflater) }
    private val adapter = TodoAdapter()

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        val todo = it.data?.getStringExtra("todo")
        Log.d("TODO", todo?:"Null")
        if(todo != null){
            val db = TodoDBHelper(this).writableDatabase
            db.execSQL("INSERT INTO TABLE_TODO (todo) VALUES (?)", arrayOf(todo))
            loadTodo()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            launcher.launch(Intent(this, AddTodoActivity::class.java))
        }

        binding.recyclerView.adapter = adapter

        loadTodo()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add(0, 0, 0, "설정")
        menu.findItem(0).apply {
            setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when(item.itemId){
            0 -> {
                startActivity(Intent(this, TodoSettingActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    private fun loadTodo(){
        val db = TodoDBHelper(this).readableDatabase
        val cursor = db.rawQuery("SELECT todo FROM TABLE_TODO ORDER BY _id DESC", null)
        val list = mutableListOf<String>()
        while(cursor.moveToNext()){
            list.add(cursor.getString(0))
        }
        adapter.list = list
        adapter.notifyDataSetChanged()
    }
}