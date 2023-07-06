package com.example.a4monthbish.ui.notifications.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.a4monthbish.data.Car
import com.example.a4monthbish.databinding.ItemTaskBinding
import com.example.a4monthbish.ui.notifications.NotificationsFragment

class CarAdapter(private val click: NotificationsFragment, ):Adapter<CarAdapter.CarViewHolder>() {

    private val list = arrayListOf<Car>()

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.bind(list[position])

        holder.itemView.setOnLongClickListener {
            click.longCLick(list[position])
            true
        }
        holder.itemView.setOnClickListener {
            click.changeItem((list[position]))
        }
    }

    fun setCar(cars: List<Car>){
        list.clear()
        list.addAll(cars)
        notifyDataSetChanged()
    }

    fun deleteCar(position: Int){
        list.removeAt(position)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        return CarViewHolder(ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false ))
    }
    override fun getItemCount(): Int  = list.size
    inner class CarViewHolder(private val binding: ItemTaskBinding):ViewHolder(binding.root) {
        fun bind(car : Car) = with(binding) {
            tvTitle.text = car.label
            tvDesk.text = car.model
        }
    }
    interface LongClick{
        fun longCLick(task: Car)
        fun changeItem(task: Car)
    }

}