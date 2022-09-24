package com.hongmu.sesac.activities

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import com.hongmu.sesac.databinding.ActivityC33Binding

class C33Activity : AppCompatActivity() {

    private val binding by lazy { ActivityC33Binding.inflate(layoutInflater) }

    val todoList = mutableListOf<String>()
    lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todoList)
        binding.listView.adapter = adapter
        
        binding.listView.setOnItemClickListener { adapterView, view, i, l ->
            AlertDialog.Builder(this)
                .setTitle("제거할까요?")
                .setPositiveButton("제거"
                ) { _, _ ->
                    todoList.removeAt(i)
                    adapter.notifyDataSetChanged()
                }
                .setNegativeButton("취소", null)
                .create()
                .show()
        }

        binding.btn.setOnClickListener {
            todoList.add(binding.input.text.toString())
            binding.input.text.clear()
            adapter.notifyDataSetChanged()
        }

    }
}