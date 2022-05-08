package com.example.githubinfo.users

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.githubinfo.R

class MainActivity : AppCompatActivity() {

    var edUsername: EditText? = null
    lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edUsername= findViewById(R.id.username)
        btnLogin = findViewById(R.id.login)

        btnLogin.setOnClickListener {
            getUserDetail()
        }
    }

     fun getUserDetail() {
        val username = edUsername!!.text.toString()
        val i = Intent(this, UserDetailedActivity::class.java)
        val bundle = Bundle()
        bundle.putString("username", username)
        i.putExtras(bundle)
        startActivity(i)
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}