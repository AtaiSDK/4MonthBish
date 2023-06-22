package com.example.a4monthbish.ui.home.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.a4monthbish.databinding.ItemTaskBinding
import com.example.a4monthbish.model.Task
import kotlin.reflect.KFunction1

class TaskAdapter(private val click : LongClick):Adapter<TaskAdapter.TaskViewHolder>() {

    private val list = arrayListOf<Task>()

    fun setTasks(tasks: List<Task>){
        list.clear()
        list.addAll(tasks)
        notifyDataSetChanged()
    }

    fun deleteTask(position: Int){
        list.removeAt(position)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false ))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(list[position])

            holder.itemView.setOnLongClickListener {
                click.longCLick(list[position])
                true
            }
    }

    override fun getItemCount(): Int  = list.size


    inner class TaskViewHolder(private val binding: ItemTaskBinding):ViewHolder(binding.root) {
        val currentTask = list[position]
        fun bind(task: Task) = with(binding) {
            tvTitle.text = task.title
            tvDesk.text = task.desk
        }
    }
    interface LongClick{
        fun longCLick(task: Task)
    }

}