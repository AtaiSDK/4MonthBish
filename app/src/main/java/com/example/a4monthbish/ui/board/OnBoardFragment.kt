package com.example.a4monthbish.ui.board

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a4monthbish.R
import com.example.a4monthbish.databinding.FragmentOnBoardBinding
import com.example.a4monthbish.databinding.FragmentProfileBinding

class OnBoardFragment : Fragment() {
    private var _binding: FragmentOnBoardBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }
}