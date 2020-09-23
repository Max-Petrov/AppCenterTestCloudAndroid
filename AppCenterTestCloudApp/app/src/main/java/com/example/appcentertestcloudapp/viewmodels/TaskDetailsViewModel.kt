package com.example.appcentertestcloudapp.viewmodels

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appcentertestcloudapp.TaskRepository
import com.example.appcentertestcloudapp.models.Task

class TaskDetailsViewModel : ViewModel(), LifecycleObserver {

    val currentTask = MutableLiveData<Task>()

    fun initialize(taskId: String) {
        currentTask.value = TaskRepository.getTaskById(taskId)!!
    }

    fun updateTask(name: String, description: String?, isDone: Boolean) {
        TaskRepository.updateTask(
            currentTask.value!!.copy(
                name = name,
                description = description,
                isDone = isDone
            )
        )
    }
}