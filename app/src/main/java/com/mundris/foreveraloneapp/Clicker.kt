package com.mundris.foreveraloneapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mundris.foreveraloneapp.databinding.ActivityClickerBinding

class Clicker : AppCompatActivity() {

    private lateinit var binding: ActivityClickerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClickerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var counter = 0

        binding.btnClicker.setOnClickListener {
            binding.clickerValue.text = (++counter).toString()
        }

        binding.clickerBtnBack.setOnClickListener{
            val intent = Intent (this, Navigation::class.java).apply{}
            startActivity(intent)
        }
    }
}