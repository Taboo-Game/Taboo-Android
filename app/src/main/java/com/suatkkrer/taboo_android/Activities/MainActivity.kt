package com.suatkkrer.taboo_android.Activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.suatkkrer.taboo_android.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()


        

    }

    fun ClassicTaboo(view: View) {
        val intent = Intent(this, TeamActivity::class.java)
        startActivity(intent)
    }
    fun DrawTaboo(view: View) {
        val intent = Intent(this, DrawGameActivity::class.java)
        startActivity(intent)
    }
    fun Settings(view: View) {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }
    fun AboutGame(view: View) {
        val intent = Intent(this, AboutGameActivity::class.java)
        startActivity(intent)
    }
}