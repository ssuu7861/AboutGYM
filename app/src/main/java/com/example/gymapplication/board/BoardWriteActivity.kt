package com.example.gymapplication.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.gymapplication.R
import com.example.gymapplication.contentsList.BookmarkModel
import com.example.gymapplication.databinding.ActivityBoardWriteBinding
import com.example.gymapplication.utils.FBAuth
import com.example.gymapplication.utils.FBRef

class BoardWriteActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBoardWriteBinding

    private val TAG = BoardWriteActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_board_write)


        binding.writeBtn.setOnClickListener{

            val title = binding.titleArea.text.toString()
            val content = binding.contentArea.text.toString()
            val uid = FBAuth.getUid()
            val time = FBAuth.getTime()

            FBRef.boardRef
                .push()
                .setValue(BoardModel(title, content, uid, time))
            Toast.makeText(this, "게시글 입력을 완료했어요!", Toast.LENGTH_LONG).show()

            finish()


        }
    }
}