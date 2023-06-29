package com.example.a4monthbish.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.a4monthbish.R
import com.example.a4monthbish.databinding.FragmentTaskBinding
import com.example.a4monthbish.model.Task
import com.example.a4monthbish.ui.App
import com.example.a4monthbish.ui.home.HomeFragment.Companion.ADD_TASK
import com.example.a4monthbish.ui.home.HomeFragment.Companion.CHANGE_TASK
import com.example.a4monthbish.ui.home.HomeFragment.Companion.ID

class TaskFragment : Fragment() {

    private lateinit var binding: FragmentTaskBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {
            when (arguments?.getString(ID)) {
                ADD_TASK -> {
                    saveTask()
                }
                CHANGE_TASK -> {
                    val task = arguments?.getSerializable(CHANGE_TASK)
                    changeTask(task as Task)
                }
            }
        }
    }

    private fun saveTask() {
        binding.btnSave.setOnClickListener {
            val title = binding.etTitle.text.toString()
            val desk = binding.etDesc.text.toString()
            App.db.taskDao().insert(Task(null, title, desk))
            findNavController().navigate(R.id.navigation_home)
        }

    }
    private fun changeTask(task: Task) {
        binding.etTitle.setText(task.title)
        binding.etDesc.setText(task.desk)
        binding.btnSave.setOnClickListener {
            val id = task.id
            val title = binding.etTitle.text.toString()
            val desk = binding.etDesc.text.toString()
            App.db.taskDao().update(Task(id, title, desk))
            findNavController().navigate(R.id.navigation_home)
        }
    }
}