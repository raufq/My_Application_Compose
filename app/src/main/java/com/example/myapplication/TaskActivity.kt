package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TaskActivity(): Activity() {
    lateinit var taskList: RecyclerView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.task_activity)
        taskList = findViewById(R.id.task_list)
        var items = ArrayList<String>()
        items.add("demo")
        items.add("demo1")
        val taskAdapter = TaskAdapter(items)
        val linearLayoutManager = LinearLayoutManager(this)
        taskList.layoutManager = linearLayoutManager
        taskList.adapter = taskAdapter
    }
}