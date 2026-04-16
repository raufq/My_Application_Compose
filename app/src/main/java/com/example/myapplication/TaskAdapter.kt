package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(val items: ArrayList<String>):RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TaskAdapter.TaskViewHolder {

        var inflater = LayoutInflater.from(parent.context)
        var view = inflater.inflate(R.layout.single_item,parent,false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskAdapter.TaskViewHolder, position: Int) {
        holder.taskNameTv.setText(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var taskNameTv = itemView.findViewById<TextView>(R.id.task_name_tv)
    }
}