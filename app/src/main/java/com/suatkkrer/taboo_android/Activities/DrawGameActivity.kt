package com.suatkkrer.taboo_android.Activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.suatkkrer.taboo_android.R
import com.suatkkrer.taboo_android.View.CanvasView

class DrawGameActivity : AppCompatActivity() {

    private var canvasView: CanvasView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draw_game)


        canvasView = findViewById(R.id.canvas) as CanvasView

    }

    fun clearCanvas(view: View) {
        canvasView!!.clearCanvas()
    }
}