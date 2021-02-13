package com.example.gymkotlin

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login()
    }

   private fun login () {
       GlobalScope.launch {
           delay(2000)
           intent = Intent(this@LoginActivity, MainActivity::class.java)
           startActivity(intent)
       }
   }

}


