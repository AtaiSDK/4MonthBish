package com.example.a4monthbish.ui.board

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.a4monthbish.R
import com.example.a4monthbish.databinding.ItemBoardBinding

class BoardAdapter : Adapter<BoardAdapter.BoardViewHolder>() {
    private val imgList =
        listOf(androidx.core.R.drawable.notification_icon_background, R.drawable.ic_profile)
    private val titleList = listOf("Title1", "Title2")

    class BoardViewHolder(private val binding: ItemBoardBinding) : ViewHolder(binding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}

