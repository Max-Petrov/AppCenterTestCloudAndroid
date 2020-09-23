package com.example.appcentertestcloudapp.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appcentertestcloudapp.models.Task

class TasksRecyclerViewAdapter(
    private val tasksList: List<Task>,
    private val onClick: (task: Task) -> Unit
) : RecyclerView.Adapter<TasksListItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksListItemViewHolder {
        return TasksListItemViewHolder(parent, onClick)
    }

    override fun getItemCount(): Int {
        return tasksList.size
    }

    override fun onBindViewHolder(holder: TasksListItemViewHolder, position: Int) {
        holder.bind(tasksList[position])
    }
}