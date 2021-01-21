package com.suatkkrer.taboo_android.Activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.suatkkrer.taboo_android.R
import com.suatkkrer.taboo_android.Adapter.RecyclerViewAdapter
import com.suatkkrer.taboo_android.Model.WordModel
import kotlinx.android.synthetic.main.activity_my_words.*
import java.lang.Exception
import java.util.ArrayList

class MyWordsActivity : AppCompatActivity(), RecyclerViewAdapter.Listener {


    private var recyclerViewAdapter : RecyclerViewAdapter? = null
    var tabooList = ArrayList<WordModel>()
    var idList = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_words)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()


        try {

            val sqLiteDatabase = this.openOrCreateDatabase("Words", Context.MODE_PRIVATE,null)

            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS words(id INTEGER PRIMARY KEY,anakelime TEXT,kelime1 TEXT,kelime2 TEXT,kelime3 TEXT,kelime4 TEXT,kelime5 TEXT)")

            val cursor = sqLiteDatabase.rawQuery("SELECT * FROM words",null)

            var idSQL = cursor.getColumnIndex("id")
            var anakelimeSQL = cursor.getColumnIndex("anakelime")
            var kelime1SQL = cursor.getColumnIndex("kelime1")
            var kelime2SQL = cursor.getColumnIndex("kelime2")
            var kelime3SQL = cursor.getColumnIndex("kelime3")
            var kelime4SQL = cursor.getColumnIndex("kelime4")
            var kelime5SQL = cursor.getColumnIndex("kelime5")

            while (cursor.moveToNext()){
                tabooList.add(WordModel(cursor.getString(anakelimeSQL),
                        cursor.getString(kelime1SQL),cursor.getString(kelime2SQL),
                        cursor.getString(kelime3SQL),cursor.getString(kelime4SQL),cursor.getString(kelime5SQL)))
                idList.add(cursor.getInt(idSQL))
            }

            cursor.close()

        } catch (e : Exception){
            e.printStackTrace()
        }


        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        tabooList.let {
            recyclerViewAdapter = RecyclerViewAdapter(it,this@MyWordsActivity)
        }
        recyclerView.adapter = recyclerViewAdapter

    }

    override fun onItemClick(position: Int) {
            val intent = Intent(this, AddWordsActivity::class.java).apply {
                putExtra("anaKelime", tabooList[position].anaKelime)
                putExtra("kelime1", tabooList[position].kelime1)
                putExtra("kelime2", tabooList[position].kelime2)
                putExtra("kelime3", tabooList[position].kelime3)
                putExtra("kelime4", tabooList[position].kelime4)
                putExtra("kelime5", tabooList[position].kelime5)
                putExtra("id", idList[position])
                putExtra("MyWords", true)
            }
        startActivity(intent)
    }


}