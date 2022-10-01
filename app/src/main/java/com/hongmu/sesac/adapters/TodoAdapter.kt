package com.hongmu.sesac.adapters

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hongmu.sesac.databinding.ItemTodoBinding

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){
    var list = mutableListOf<String>()

    fun add(todo: String){
        list.add(todo)
        notifyItemInserted(list.size - 1)
    }

    inner class TodoViewHolder(var binding: ItemTodoBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(todo: String){
            binding.textTodo.text = todo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), null, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}