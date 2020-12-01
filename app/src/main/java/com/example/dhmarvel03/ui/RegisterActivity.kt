package com.example.dhmarvel03.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.dhmarvel03.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        Glide
            .with(this)
            .load("url")
            .centerCrop()
            .placeholder(R.drawable.register)
            .into(imageViewRegister)

        clickBtnRegister()
    }

    private fun clickBtnRegister() {
        val buttonRegister: Button = findViewById<View>(R.id.buttonRegister) as Button
        buttonRegister.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}