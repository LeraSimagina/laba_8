package com.leonchik.android.laba_8

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.leonchik.android.laba_8.database.TDLDatabase
import com.leonchik.android.laba_8.database.TaskDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {
    private lateinit var taskDao: TaskDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        taskDao = TDLDatabase.getDatabase(application).taskDao()
        findViewById<Button>(R.id.add_button).setOnClickListener {
            val content = findViewById<EditText>(R.id.contet_task).text.toString()
            val data = findViewById<EditText>(R.id.data_task).text.toString()
            val priority = when (findViewById<RadioGroup>(R.id.priority_group).checkedRadioButtonId) {
                R.id.high_priority -> 1
                R.id.medium_priority -> 2
                else -> 3
            }
            val task = Task(content = content, data=data,  priority = priority)
            AddTask(task)
            finish()
        }
    }
    private fun AddTask(task: Task) {
        CoroutineScope(Dispatchers.IO).launch {
            taskDao.addTask(task)
        }
    }
}