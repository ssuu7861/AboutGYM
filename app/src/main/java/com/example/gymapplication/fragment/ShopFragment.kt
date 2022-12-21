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
import com.example.gymapplication.databinding.FragmentMapBinding
import com.example.gymapplication.databinding.FragmentShopBinding


class ShopFragment : Fragment() {

    private lateinit var  binding : FragmentShopBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_shop, container, false)
//        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shop, container, false)
//
//        binding.homeTap.setOnClickListener {
//            it.findNavController().navigate(R.id.action_shopFragment_to_homeFragment)
//        }
//        binding.communityTap.setOnClickListener {
//            it.findNavController().navigate(R.id.action_shopFragment_to_communityFragment)
//        }
//        binding.trainerTap.setOnClickListener {
//            it.findNavController().navigate(R.id.action_shopFragment_to_trainerFragment)
//        }
//        binding.gymTap.setOnClickListener {
//            it.findNavController().navigate(R.id.action_shopFragment_to_gymFragment)
//        }
//        binding.mapTap.setOnClickListener {
//            it.findNavController().navigate(R.id.action_shopFragment_to_mapFragment)
//        }
        val webView : WebView = view.findViewById(R.id.shopWebView)
        webView.loadUrl("http://heodak.com/?utm_source=naver_pc&utm_medium=bsa&utm_campaign=logo_221219&utm_term=%ED%97%88%EB%8B%AD&utm_content=home&n_media=27758&n_query=%ED%97%88%EB%8B%AD&n_rank=1&n_ad_group=grp-a001-04-000000026781654&n_ad=nad-a001-04-000000219730720&n_keyword_id=nkw-a001-04-000004491141370&n_keyword=%ED%97%88%EB%8B%AD&n_campaign_type=4&n_contract=tct-a001-04-000000000634181&n_ad_group_type=5&NaPm=ct%3Dlbwpirco%7Cci%3D0Au0002F8o9xn6h7iuYV%7Ctr%3Dbrnd%7Chk%3D795e3450df010061c5bc2b67c4c6152d96ce019a")
        return view
    }
}