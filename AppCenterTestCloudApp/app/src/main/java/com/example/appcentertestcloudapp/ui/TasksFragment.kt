package com.example.appcentertestcloudapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appcentertestcloudapp.R
import com.example.appcentertestcloudapp.models.Task
import com.example.appcentertestcloudapp.viewmodels.TasksListViewModel
import kotlinx.android.synthetic.main.fragment_tasks.*

class TasksFragment : Fragment() {

    private val viewModel by viewModels<TasksListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tasks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViewModel()
        observeViewModel()
    }

    private fun initializeViewModel() {
        lifecycle.addObserver(viewModel)
    }

    private fun observeViewModel() {
        viewModel.tasksList.observe(viewLifecycleOwner, Observer {
            showTasks(it)
        })
    }

    private fun showTasks(tasks: List<Task>) {
        tasksRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = TasksRecyclerViewAdapter(tasks) {
                showTaskDetails(it)
            }
        }
    }

    private fun showTaskDetails(task: Task) {
        val actionToTaskDetails = TasksFragmentDirections.actionTasksToTaskDetails()
        actionToTaskDetails.taskId = task.id
        findNavController().navigate(actionToTaskDetails)
    }
}