package com.example.gymapplication.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gymapplication.R
import com.example.gymapplication.contentsList.BookmarkModel
import com.example.gymapplication.contentsList.BookmarkRVAdapter
import com.example.gymapplication.contentsList.ContentModel
import com.example.gymapplication.databinding.FragmentCommunityBinding
import com.example.gymapplication.databinding.FragmentGymBinding
import com.example.gymapplication.utils.FBAuth
import com.example.gymapplication.utils.FBRef
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener


class GymFragment : Fragment() {
    private lateinit var  binding : FragmentGymBinding
    private val TAG = GymFragment::class.java.simpleName
    var bookmarkIdList = mutableListOf<String>()
    val items = ArrayList<ContentModel>()
    val itemKeyList = ArrayList<String>()
    lateinit var rvAdapter: BookmarkRVAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_gym, container, false)


        getBookmarkData()

        rvAdapter = BookmarkRVAdapter(requireContext(),items, itemKeyList, bookmarkIdList )
        val rv : RecyclerView = binding.bookmarkRV
        rv.adapter = rvAdapter
        rv.layoutManager = GridLayoutManager(requireContext(), 2)

        binding.homeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_gymFragment_to_homeFragment)
        }
        binding.communityTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_gymFragment_to_communityFragment)
        }
        binding.trainerTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_gymFragment_to_trainerFragment)
        }
        binding.mapTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_gymFragment_to_mapFragment)
        }
        binding.shopTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_gymFragment_to_shopFragment)
        }

        return binding.root
    }
    private fun getCategoryData(){
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for (dataModel in dataSnapshot.children) {


                    val item = dataModel.getValue(ContentModel::class.java)
                    if(bookmarkIdList.contains(dataModel.key.toString())){
                        items.add(item!!)
                        itemKeyList.add(dataModel.key.toString())
                    }

                }
                rvAdapter.notifyDataSetChanged()

            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("ContentListActivity", "loadPost:onCancelled", databaseError.toException())
            }
        }
        FBRef.category1.addValueEventListener(postListener)
        FBRef.category2.addValueEventListener(postListener)

    }
    private fun getBookmarkData(){

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for (dataModel in dataSnapshot.children) {

                    bookmarkIdList.add(dataModel.key.toString())
                }
                getCategoryData()

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("ContentListActivity", "loadPost:onCancelled", databaseError.toException())
            }
        }
        FBRef.bookmarkRef.child(FBAuth.getUid()).addValueEventListener(postListener)
    }
}