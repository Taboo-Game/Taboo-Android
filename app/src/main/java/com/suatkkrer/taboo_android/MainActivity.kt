package com.suatkkrer.taboo_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        

    }

    fun ClassicTaboo(view: View) {}
    fun DrawTaboo(view: View) {}
    fun Settings(view: View) {}
    fun AboutGame(view: View) {}
}