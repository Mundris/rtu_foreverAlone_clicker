package com.mundris.foreveraloneapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mundris.foreveraloneapp.databinding.ActivityNavigationBinding

class Navigation : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnClicker.setOnClickListener{
            val intent = Intent(this, Clicker::class.java).apply {  }
            startActivity(intent)
        }

        binding.btnChat.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java).apply {  }
            startActivity(intent)
        }
    }
}