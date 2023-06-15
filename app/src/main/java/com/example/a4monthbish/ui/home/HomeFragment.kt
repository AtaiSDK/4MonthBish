package com.example.a4monthbish.ui.home

import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.a4monthbish.R
import com.example.a4monthbish.databinding.FragmentHomeBinding
import com.example.a4monthbish.model.Task
import com.example.a4monthbish.ui.home.Adapter.TaskAdapter
import com.example.a4monthbish.ui.task.TaskFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val adapter = TaskAdapter()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFragmentResultListener(TaskFragment.TASK_REQUEST, { _, bundle ->

            val data = bundle.getSerializable(TaskFragment.TASK_KEY) as Task
            adapter.setTask(data)
        })
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
        binding.recyclerView.adapter = adapter
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}