package com.suatkkrer.taboo_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class DrawGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draw_game)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
    }
}