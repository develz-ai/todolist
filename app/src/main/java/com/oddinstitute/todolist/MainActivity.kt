package com.oddinstitute.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        todoItems.adapter = todoAdapter
        todoItems.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener {
            val maintodoTitle = todoTitle.text.toString()
            if (maintodoTitle.isNotEmpty()) {
                val todo = Todo(maintodoTitle)
                todoAdapter.addTodo(todo)
                todoTitle.text.clear()
            }
        }
        btnDeleteDoneTodos.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}