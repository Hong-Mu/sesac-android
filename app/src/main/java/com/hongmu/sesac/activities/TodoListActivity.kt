package com.hongmu.sesac.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.hongmu.sesac.adapters.TodoAdapter
import com.hongmu.sesac.databinding.ActivityTodoListBinding

class TodoListActivity : AppCompatActivity() {

    private val binding by lazy { ActivityTodoListBinding.inflate(layoutInflater) }
    private val adapter = TodoAdapter()

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        val todo = it.data?.getStringExtra("todo")
        Log.d("TODO", todo?:"Null")
        if(todo != null){
            adapter.add(todo)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            launcher.launch(Intent(this, AddTodoActivity::class.java))
        }

        binding.recyclerView.adapter = adapter
    }
}