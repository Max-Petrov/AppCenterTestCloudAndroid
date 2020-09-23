package com.example.appcentertestcloudapp

import com.example.appcentertestcloudapp.models.Task

object TaskRepository {

    val tasksMap = mutableMapOf<String, Task>(
        "1" to Task("1", "Test task 1", "Test description 1", true),
        "2" to Task("2", "Test task 2", "Test description 2", true),
        "3" to Task("3", "Test task 3", "Test description 3", false),
        "4" to Task("4", "Test task 4", "Test description 4", false),
        "5" to Task("5", "Test task 5", "Test description 5", false)
    )

    fun getTasks(): List<Task> {
        return tasksMap.values.toList()
    }

    fun getTaskById(id: String): Task? {
        return tasksMap[id]
    }

    fun updateTask(task: Task) {
        tasksMap[task.id] = task
    }
}