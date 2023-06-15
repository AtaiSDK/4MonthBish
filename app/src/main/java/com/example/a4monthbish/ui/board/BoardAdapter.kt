package com.example.a4monthbish.ui.board

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.a4monthbish.R
import com.example.a4monthbish.databinding.ItemBoardBinding
import com.example.a4monthbish.model.OnBoarding

class BoardAdapter(private val OnClick: ()-> Unit): Adapter<BoardAdapter.BoardViewHolder>() {
    private val animList = listOf(R.raw.anim, R.raw.anim1, R.raw.anim2)
    private val titleList = listOf("Title 1", "Title 2", "Title 3")
    private val desList = listOf("Des 1", "Des 2", "Des 3")


    inner class BoardViewHolder(private val binding: ItemBoardBinding) : ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.anim.setAnimation(animList[position])
            binding.title.text = titleList[position]
            binding.desc.text = desList[position]
            binding.startBtn.isVisible = adapterPosition == animList.lastIndex
            binding.startBtn.setOnClickListener {
                OnClick()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        return BoardViewHolder(ItemBoardBinding.inflate(LayoutInflater.from(parent.context),
        parent, false))
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = animList.size
}

