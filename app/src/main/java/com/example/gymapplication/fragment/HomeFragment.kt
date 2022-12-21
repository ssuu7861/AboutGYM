package com.example.gymapplication.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.gymapplication.R
import com.example.gymapplication.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.communityTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_communityFragment)
        }
        binding.trainerTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_trainerFragment)
        }
        binding.gymTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_gymFragment)
        }
        binding.mapTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_mapFragment)
        }
        binding.shopTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_shopFragment)
        }
        return binding.root
    }
}