package com.suatkkrer.taboo_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TeamActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
    }

    fun firstTeamMember(view: View) {}
    fun secondTeamMember(view: View) {}
    fun startGameButton(view: View) {}
}