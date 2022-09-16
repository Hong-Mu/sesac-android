package com.hongmu.sesac

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActivityAdapter(private val activities: List<Class<*>>) : RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder>() {
    inner class ActivityViewHolder(val view: View): RecyclerView.ViewHolder(view){
        fun bind(activity: Class<*>){
            view.findViewById<TextView>(android.R.id.text1).apply {
                text = activity.simpleName

                setOnClickListener {
                    view.context.startActivity(Intent(view.context, activity))
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return ActivityViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        holder.bind(activities[position])
    }

    override fun getItemCount() = activities.size
}