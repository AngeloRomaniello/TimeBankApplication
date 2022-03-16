package com.example.ourapplication

import TodoAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvListOfItems: RecyclerView
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etAddButton:Button=findViewById(R.id.etAddButton)
        val etDeleteButton:Button=findViewById(R.id.etDeleteButton)
        todoAdapter = TodoAdapter(mutableListOf())

        rvListOfItems= findViewById(R.id.rvListOfItems)
        rvListOfItems.adapter=todoAdapter
        rvListOfItems.layoutManager = LinearLayoutManager(this)

        etAddButton.setOnClickListener {
            val etTitle:EditText=findViewById(R.id.etTitle)
            val todoTitle = etTitle.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                etTitle.text.clear()
            }
        }
        etDeleteButton.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}