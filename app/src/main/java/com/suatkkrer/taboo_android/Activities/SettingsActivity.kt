package com.suatkkrer.taboo_android.Activities

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import com.suatkkrer.taboo_android.R
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    var pasSeek : Int? = null
    var timeSeek : Int? = null
    var aimSeek : Int? = null
    var drawingSeek : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()


        try {
            val sqliteDatabase : SQLiteDatabase = this.openOrCreateDatabase("Settings", MODE_PRIVATE, null)

            sqliteDatabase.execSQL("CREATE TABLE IF NOT EXISTS settings (pas INTEGER, time INTEGER, aim INTEGER, draw INTEGER)")

            val cursor : Cursor = sqliteDatabase.rawQuery("SELECT * FROM settings",null)

            var pasData = cursor.getColumnIndex("pas")
            var timeData = cursor.getColumnIndex("time")
            var aimData = cursor.getColumnIndex("aim")
            var drawData = cursor.getColumnIndex("draw")

            while (cursor.moveToNext()){
                pasSeekBar.progress = cursor.getInt(pasData)
                passText.text = cursor.getInt(pasData).toString()
                timeSeekBar.progress = cursor.getInt(timeData)
                timeText.text = cursor.getInt(timeData).toString()
                aimSeekBar.progress = cursor.getInt(aimData)
                aimText.text = cursor.getInt(aimData).toString()
                drawingSeekBar.progress = cursor.getInt(drawData)
                drawingText.text = cursor.getInt(drawData).toString()
                pasSeek = cursor.getInt(pasData)
                timeSeek = cursor.getInt(timeData)
                aimSeek = cursor.getInt(aimData)
                drawingSeek = cursor.getInt(drawData)
            }

            cursor.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }


        pasSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                passText.text = "$p1"
                pasSeek = p1
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })


        timeSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                timeText.text = "$p1"
                timeSeek = p1
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })


        aimSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                aimText.text = "$p1"
                aimSeek = p1
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

        drawingSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                drawingText.text = "$p1"
                drawingSeek = p1
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })


    }

    override fun onPause() {
        super.onPause()

        try {
            val sqliteDatabase: SQLiteDatabase =
                    this.openOrCreateDatabase("Settings", MODE_PRIVATE, null)

            sqliteDatabase.execSQL("CREATE TABLE IF NOT EXISTS settings (pas INTEGER, time INTEGER, aim INTEGER, draw INTEGER)")

            sqliteDatabase.execSQL("DELETE FROM settings")

            sqliteDatabase.execSQL("CREATE TABLE IF NOT EXISTS settings (pas INTEGER, time INTEGER, aim INTEGER, draw INTEGER)")

            sqliteDatabase.execSQL("INSERT INTO settings (pas, time, aim, draw) VALUES (${pasSeek},${timeSeek},${aimSeek},${drawingSeek})")

        } catch (e : Exception){
            e.printStackTrace();
        }

    }


    fun myWords(view: View) {
        val intent = Intent(this, MyWordsActivity::class.java)
        startActivity(intent)
        finish()
    }
    fun addWords(view: View) {
        val intent = Intent(this, AddWordsActivity::class.java)
        startActivity(intent)
    }
}