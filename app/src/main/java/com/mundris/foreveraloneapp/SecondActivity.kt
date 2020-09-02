package com.mundris.foreveraloneapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mundris.foreveraloneapp.databinding.ActivitySecondBinding
import com.mundris.foreveraloneapp.MainActivity.Companion.EXTRA_MESSAGE
import com.mundris.foreveraloneapp.MainActivity.Companion.EXTRA_REPLY

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val message = intent.getStringExtra(EXTRA_MESSAGE)
        binding.textViewReceivedMsg.text = message

        binding.buttonReply.setOnClickListener{
            val reply = binding.editTextMultilineReply.text.toString()

            val result = Intent().apply {
                putExtra(EXTRA_REPLY, reply)
            }
            setResult(Activity.RESULT_OK, result)
            finish()
        }


    }
}