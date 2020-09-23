package com.example.appcentertestcloudapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appcentertestcloudapp.R
import com.example.appcentertestcloudapp.models.Task
import kotlinx.android.synthetic.main.tasks_list_item.view.*

class TasksListItemViewHolder(parent: ViewGroup, private val onClick: (task: Task) -> Unit) :
    RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.tasks_list_item,
            parent,
            false)
    ) {

    fun bind(task: Task) {
        itemView.taskTitleTextView.text = task.name
        itemView.taskDescriptionTextView.visibility = if (task.description != null) View.VISIBLE else View.GONE
        if (task.description != null) {
            itemView.taskDescriptionTextView.text = task.description
        }
        itemView.taskStatusTextView.text = if (task.isDone) "Done" else ""

        itemView.setOnClickListener {
            onClick(task)
        }
    }
}