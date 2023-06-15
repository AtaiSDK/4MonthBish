package com.example.a4monthbish.ui.board

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.a4monthbish.R
import com.example.a4monthbish.databinding.FragmentOnBoardBinding
import com.example.a4monthbish.databinding.FragmentProfileBinding
import com.example.a4monthbish.databinding.ItemBoardBinding
import me.relex.circleindicator.CircleIndicator
import me.relex.circleindicator.CircleIndicator3

class OnBoardFragment : Fragment() {
    private val adapter = BoardAdapter(this::OnClick)

    private fun OnClick() {
        findNavController().navigateUp()
    }


    private lateinit var binding : FragmentOnBoardBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pager.adapter = adapter
        binding.indicator.setViewPager(binding.pager)


    }
}