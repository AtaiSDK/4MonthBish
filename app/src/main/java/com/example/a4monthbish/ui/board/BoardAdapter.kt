package com.example.a4monthbish.ui.board

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.a4monthbish.R
import com.example.a4monthbish.databinding.ItemBoardBinding
import com.example.a4monthbish.model.OnBoarding

class BoardAdapter : Adapter<BoardAdapter.BoardViewHolder>() {
    val list = listOf(
        OnBoarding("Title1", "Desk1", ""),
        OnBoarding("Title2", "Desk2", ""),
        OnBoarding("Title3", "Desk3", "")
    )

    class BoardViewHolder(private val binding: ItemBoardBinding) : ViewHolder(binding.root) {
        fun bind(onBoarding: OnBoarding) {

            binding.desk.text = onBoarding.desc
            binding.title.text = onBoarding.title

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        return BoardViewHolder(ItemBoardBinding.inflate(LayoutInflater.from(parent.context),
        parent, false))
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}

