package com.suatkkrer.taboo_android.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.suatkkrer.taboo_android.R

class TeamActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)

    }


    fun startGameButton(view: View) {
        val intent = Intent(this,TabooActivity::class.java)
        startActivity(intent)
        finish()

    }
}