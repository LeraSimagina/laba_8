package com.leonchik.android.laba_8

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

class TaskListFragment : Fragment(R.layout.fragment_task_list){

    private lateinit var recyclerView: RecyclerView

    private val taskListViewModel: TaskListViewModel by lazy {
        ViewModelProvider(this).get(TaskListViewModel::class.java)
    }

    companion object
    {
        fun newInstance()=TaskListFragment()
    }
}