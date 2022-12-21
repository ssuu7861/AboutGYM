package com.example.gymapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.gymapplication.R
import com.example.gymapplication.databinding.FragmentCommunityBinding
import com.example.gymapplication.databinding.FragmentMapBinding


class MapFragment : Fragment() {
    private lateinit var  binding : FragmentMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_map, container, false)

        val view = inflater.inflate(R.layout.fragment_map, container, false)
        val webView : WebView = view.findViewById(R.id.mapWebView)
        webView.loadUrl("https://map.kakao.com/")
        binding.homeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_mapFragment_to_homeFragment)
        }
        binding.communityTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_mapFragment_to_communityFragment)
        }
        binding.trainerTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_mapFragment_to_trainerFragment)
        }
        binding.gymTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_mapFragment_to_gymFragment)
        }
        binding.shopTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_mapFragment_to_shopFragment)
        }
        return view
    }
}