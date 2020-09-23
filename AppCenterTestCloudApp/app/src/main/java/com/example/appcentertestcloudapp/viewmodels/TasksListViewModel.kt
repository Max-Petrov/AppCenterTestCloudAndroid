package com.example.appcentertestcloudapp.viewmodels

import androidx.lifecycle.*
import com.example.appcentertestcloudapp.TaskRepository
import com.example.appcentertestcloudapp.models.Task

class TasksListViewModel : ViewModel(), LifecycleObserver {

    val tasksList = MutableLiveData<List<Task>>()

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun loadData() {
        tasksList.value = TaskRepository.getTasks()
    }
}