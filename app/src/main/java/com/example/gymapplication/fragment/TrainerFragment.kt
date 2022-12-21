package com.example.gymapplication.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.gymapplication.R
import com.example.gymapplication.contentsList.ContentListActivity
import com.example.gymapplication.databinding.FragmentCommunityBinding
import com.example.gymapplication.databinding.FragmentTrainerBinding


class TrainerFragment : Fragment() {
    private lateinit var  binding : FragmentTrainerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_trainer, container, false)

        binding.category1.setOnClickListener {

            val intent = Intent(context, ContentListActivity::class.java)
            intent.putExtra("category", "category1")
            startActivity(intent)

        }

        binding.category2.setOnClickListener {
            val intent = Intent(context, ContentListActivity::class.java)
            intent.putExtra("category", "category2")
            startActivity(intent)

        }

        binding.homeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_trainerFragment_to_homeFragment)
        }
        binding.communityTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_trainerFragment_to_communityFragment)
        }
        binding.gymTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_trainerFragment_to_gymFragment)
        }
        binding.mapTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_trainerFragment_to_mapFragment)
        }
        binding.shopTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_trainerFragment_to_shopFragment)
        }


        return binding.root

    }
}