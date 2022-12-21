package com.example.gymapplication.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.gymapplication.R
import com.example.gymapplication.board.BoardInsideActivity
import com.example.gymapplication.board.BoardListLVAdapter
import com.example.gymapplication.board.BoardModel
import com.example.gymapplication.board.BoardWriteActivity
import com.example.gymapplication.contentsList.BookmarkRVAdapter
import com.example.gymapplication.contentsList.ContentModel
import com.example.gymapplication.databinding.FragmentCommunityBinding
import com.example.gymapplication.utils.FBRef
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class CommunityFragment : Fragment() {

    private lateinit var binding : FragmentCommunityBinding
    private val TAG = CommunityFragment::class.java.simpleName
    private val boardDataList = mutableListOf<BoardModel>()
    private lateinit var boardRVAdapter : BoardListLVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_community, container, false)

        boardRVAdapter = BoardListLVAdapter(boardDataList)
        binding.boardListView.adapter = boardRVAdapter
        binding.boardListView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(context, BoardInsideActivity::class.java)
            intent.putExtra("title", boardDataList[position].title)
            intent.putExtra("content", boardDataList[position].content)
            intent.putExtra("time", boardDataList[position].time)
            startActivity(intent)
        }

        binding.writeBtn.setOnClickListener {
            val intent = Intent(context, BoardWriteActivity::class.java)
            startActivity(intent)
        }

        binding.homeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_communityFragment_to_homeFragment)
        }

        binding.trainerTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_communityFragment_to_trainerFragment)
        }

        binding.gymTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_communityFragment_to_gymFragment)
        }

        binding.mapTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_communityFragment_to_mapFragment)
        }
        binding.shopTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_communityFragment_to_shopFragment)
        }
        getFBBoardData()

        return binding.root
    }

    private fun getFBBoardData(){

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                boardDataList.clear()
                for (dataModel in dataSnapshot.children) {


                    val item = dataModel.getValue(BoardModel::class.java)
                    boardDataList.add(item!!)
                }
                boardDataList.reverse()
                boardRVAdapter.notifyDataSetChanged()

            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        FBRef.boardRef.addValueEventListener(postListener)


    }

}