package com.suatkkrer.taboo_android

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteStatement
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_words.*
import java.lang.Exception

class AddWordsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_words)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
    }

    fun addWordsDatabase(view: View) {

        try {
            val sqLiteDatabase = this.openOrCreateDatabase("Words", Context.MODE_PRIVATE,null)

            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS words(id INTEGER PRIMARY KEY,anakelime TEXT,kelime1 TEXT,kelime2 TEXT,kelime3 TEXT,kelime4 TEXT,kelime5 TEXT)")

            if (addMainWord.editText!!.text.toString() != "" && addWord1.editText!!.text.toString() != ""
                    && addWord2.editText!!.text.toString() != "" && addWord3.editText!!.text.toString() != ""
                    && addWord4.editText!!.text.toString() != ""&& addWord5.editText!!.text.toString() != "") {
                var addmainWord = addMainWord.editText!!.text.toString()
                var addword1 = addWord1.editText!!.text.toString()
                var addword2 = addWord2.editText!!.text.toString()
                var addword3 = addWord3.editText!!.text.toString()
                var addword4 = addWord4.editText!!.text.toString()
                var addword5 = addWord5.editText!!.text.toString()

                var sql = "INSERT INTO words (anakelime,kelime1,kelime2,kelime3,kelime4,kelime5) VALUES (?,?,?,?,?,?)"

                val statement = sqLiteDatabase.compileStatement(sql)
                statement.bindString(1,addmainWord)
                statement.bindString(2,addword1)
                statement.bindString(3,addword2)
                statement.bindString(4,addword3)
                statement.bindString(5,addword4)
                statement.bindString(6,addword5)
                statement.execute()

                Toast.makeText(this,"`...",Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(this,"Lütfen Tüm Alanları Doldurun...",Toast.LENGTH_LONG).show()
            }

        } catch (e : Exception){
            e.printStackTrace()
        }




    }
}