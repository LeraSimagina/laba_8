package com.leonchik.android.laba_8

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.leonchik.android.laba_8.database.TaskDao

class TaskFactory(private val taskDao: TaskDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TaskListViewModel(taskDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}