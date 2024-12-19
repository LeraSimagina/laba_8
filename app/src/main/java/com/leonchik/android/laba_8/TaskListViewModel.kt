package com.leonchik.android.laba_8

import androidx.lifecycle.ViewModel
import com.leonchik.android.laba_8.database.TaskDao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class TaskListViewModel (private val taskDao: TaskDao):ViewModel() {
    private val ts=MutableLiveData<List<Task>>()
    val tasks: LiveData<List<Task>> get() = ts
    fun addTask(content:String,priority:Int)
    {
        val task=Task(content=content,priority=priority)
        taskDao.addTask(task)
        getTasks()
    }
    fun getTasks()
    {
        val tasks_list=taskDao.getTask()
        ts.postValue(tasks_list)
    }
    fun delTask(task:Task)
    {
        taskDao.delTask(task)
        getTasks()
    }
}