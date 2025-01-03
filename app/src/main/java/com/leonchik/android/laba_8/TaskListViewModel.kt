package com.leonchik.android.laba_8

import androidx.lifecycle.ViewModel
import com.leonchik.android.laba_8.database.TaskDao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TaskListViewModel (private val taskDao: TaskDao):ViewModel() {
    private val ts=MutableLiveData<List<Task>>()
    val tasks: LiveData<List<Task>> get() = ts

    fun addTask(content:String,data:String,priority:Int)
    {
        val task=Task(content=content,data=data, priority=priority)
        viewModelScope.launch{
            taskDao.addTask(task)
            getTasks()
        }
    }

    fun getTasks()
    {
        viewModelScope.launch{
            val tasks_list=taskDao.getTask()
            ts.postValue(tasks_list)
        }
    }

    fun delTask(task:Task)
    {
        viewModelScope.launch{
            taskDao.delTask(task)
            getTasks()
        }
    }
}