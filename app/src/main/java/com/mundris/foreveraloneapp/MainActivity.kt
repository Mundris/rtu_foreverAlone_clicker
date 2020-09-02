package com.mundris.foreveraloneapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mundris.foreveraloneapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        const val DETAIL_REQUEST = 1
        const val EXTRA_MESSAGE = "lv.romstr.mobile.practice.MESSAGE"
        const val EXTRA_REPLY = "lv.romstr.mobile.practice.REPLY"
    }

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        if (binding.textViewReceivedReply.text.toString()==""){
            binding.textViewReplyReceivedTitle.text = ""
        }

        binding.buttonSend.setOnClickListener{
            val message = binding.editTextMultilineEnterMessage.text.toString()
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, message)
            }
            startActivityForResult(intent, DETAIL_REQUEST)
        }

        binding.mainActivityBackImage.setOnClickListener{
            val intent = Intent (this, Navigation::class.java).apply {  }
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == DETAIL_REQUEST && resultCode==Activity.RESULT_OK){
            data?.let {
                val message = data.getStringExtra(EXTRA_REPLY)
                binding.textViewReceivedReply.text = message
                binding.textViewReplyReceivedTitle.text = getString(R.string.reply_received)
                binding.editTextMultilineEnterMessage.setText("")
            }
        }
    }


}

