package com.example.a4monthbish.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.a4monthbish.R
import com.example.a4monthbish.databinding.FragmentHomeBinding
import com.example.a4monthbish.model.Task
import com.example.a4monthbish.ui.App
import com.example.a4monthbish.ui.home.Adapter.TaskAdapter

class HomeFragment : Fragment(),
    TaskAdapter.LongClick {

    private val adapter: TaskAdapter by lazy {
        TaskAdapter(this)
    }
    private var _binding: FragmentHomeBinding? = null
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

        val list = App.db.taskDao().getAll()
        adapter.setTasks(list)
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
        binding.recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun longCLick(task: Task) {
        val alert = AlertDialog.Builder(requireContext())
        alert.setTitle("Вы уверены в этом?")
            .setPositiveButton("Подтвердить") { _, _ ->
                App.db.taskDao().delete(task)
                val list = App.db.taskDao().getAll()
                adapter.setTasks(list)
            }
            .setNegativeButton("Отмена", null)
            .show()
    }
    override fun clickChange(task: Task){
        App.db.
    }
}
