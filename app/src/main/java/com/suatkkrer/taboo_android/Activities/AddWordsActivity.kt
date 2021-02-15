package com.suatkkrer.taboo_android.Activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Toast
import com.suatkkrer.taboo_android.R
import kotlinx.android.synthetic.main.activity_add_words.*
import java.lang.Exception

class AddWordsActivity : AppCompatActivity() {

    var myWords : Boolean? = null
    var mainWord : String? = null
    var word1 : String? = null
    var word2 : String? = null
    var word3 : String? = null
    var word4 : String? = null
    var word5 : String? = null
    var idSql : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_words)


        myWords = intent.getBooleanExtra("MyWords",false)
        mainWord = intent.getStringExtra("anaKelime")
        word1 = intent.getStringExtra("kelime1")
        word2 = intent.getStringExtra("kelime2")
        word3 = intent.getStringExtra("kelime3")
        word4 = intent.getStringExtra("kelime4")
        word5 = intent.getStringExtra("kelime5")
        idSql = intent.getIntExtra("id",-1)

        if (myWords == true) {
            editWord.visibility = View.VISIBLE
            deleteWord.visibility = View.VISIBLE
            saveWord.visibility = View.GONE

            addMainWord.editText!!.text = mainWord!!.toEditable()
            addWord1.editText!!.text = word1!!.toEditable()
            addWord2.editText!!.text = word2!!.toEditable()
            addWord3.editText!!.text = word3!!.toEditable()
            addWord4.editText!!.text = word4!!.toEditable()
            addWord5.editText!!.text = word5!!.toEditable()

        }

    }

    fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)

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

                Toast.makeText(this,"Kelimeniz başarıyla Eklendi...",Toast.LENGTH_LONG).show()

                val intent = Intent(this,MyWordsActivity::class.java)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()

            } else {
                Toast.makeText(this,"Lütfen Tüm Alanları Doldurun...",Toast.LENGTH_LONG).show()
            }

        } catch (e : Exception){
            e.printStackTrace()
        }




    }

    fun deleteWord(view: View) {

        try {

            val sqLiteDatabase = this.openOrCreateDatabase("Words", Context.MODE_PRIVATE,null)

            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS words(id INTEGER PRIMARY KEY,anakelime TEXT,kelime1 TEXT,kelime2 TEXT,kelime3 TEXT,kelime4 TEXT,kelime5 TEXT)")

            sqLiteDatabase.execSQL("DELETE FROM words WHERE id = $idSql")

            Toast.makeText(this,"Kelime Başarıyla Silindi...",Toast.LENGTH_SHORT).show()

            val intent = Intent(this,MyWordsActivity::class.java)
                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)

            startActivity(intent)
            finish()

        } catch (e : Exception){
            e.printStackTrace()
        }


    }

    fun editWord(view: View) {

        try {

            val sqLiteDatabase = this.openOrCreateDatabase("Words", Context.MODE_PRIVATE,null)

            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS words(id INTEGER PRIMARY KEY,anakelime TEXT,kelime1 TEXT,kelime2 TEXT,kelime3 TEXT,kelime4 TEXT,kelime5 TEXT)")

            sqLiteDatabase.execSQL("DELETE FROM words WHERE id = $idSql")

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

                Toast.makeText(this,"Kelimeniz Başarıyla Değiştirildi...",Toast.LENGTH_LONG).show()

                val intent = Intent(this,MyWordsActivity::class.java)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)

                startActivity(intent)
                finish()

            } else {
                Toast.makeText(this,"Lütfen Tüm Alanları Doldurun...",Toast.LENGTH_LONG).show()
            }






        } catch (e : Exception){
            e.printStackTrace()
        }

    }
}