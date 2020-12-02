package com.example.dhmarvel03.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dhmarvel03.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        clickBtnLogin()
        clickBtnRegister()
    }

    private fun clickBtnLogin() {
        val btnLogin: Button = findViewById<View>(R.id.buttonLogin) as Button
        btnLogin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun clickBtnRegister() {
        val textViewRegister: TextView = findViewById<View>(R.id.textViewRegister) as TextView
        textViewRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}