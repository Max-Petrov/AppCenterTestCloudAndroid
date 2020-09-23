package com.example.appcentertestcloudapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.appcentertestcloudapp.R
import com.example.appcentertestcloudapp.models.Task
import com.example.appcentertestcloudapp.viewmodels.TaskDetailsViewModel
import kotlinx.android.synthetic.main.fragment_task_details.*

class TaskDetailsFragment : Fragment() {

    private val viewModel by viewModels<TaskDetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_task_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
        initializeViewModel()
        observeViewModel()
    }

    private fun initializeViews() {
        saveButton.setOnClickListener {
            saveTaskInfo()
        }
    }

    private fun initializeViewModel() {
        val taskId = TaskDetailsFragmentArgs.fromBundle(requireArguments()).taskId
        viewModel.initialize(taskId)
    }

    private fun observeViewModel() {
        viewModel.currentTask.observe(viewLifecycleOwner, Observer {
            showTaskInfo(it)
        })
    }

    private fun showTaskInfo(task: Task) {
        taskNameEditText.setText(task.name)
        taskDescriptionEditText.setText(task.description)
        taskStatusCheckBox.isChecked = task.isDone
    }

    private fun saveTaskInfo() {
        viewModel.updateTask(taskNameEditText.text.toString(), taskDescriptionEditText.text.toString(), taskStatusCheckBox.isChecked)
    }
}