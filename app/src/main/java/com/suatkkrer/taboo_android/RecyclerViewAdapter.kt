package com.suatkkrer.taboo_android

import android.net.sip.SipSession
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.word_list.view.*

class RecyclerViewAdapter(private val wordList: ArrayList<WordModel>,private val listener : Listener) : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {

    interface Listener {
        fun onItemClick(wordModel : WordModel)
    }


    class RowHolder(view : View) : RecyclerView.ViewHolder(view) {

        fun bind(wordModel : WordModel,listener : Listener){
            itemView.setOnClickListener {
                listener.onItemClick(wordModel)
            }
            itemView.recyclerText.text = wordModel.anaKelime
            itemView.recyclerImage.setImageResource(R.drawable.dictionary)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.word_list,parent,false)
        return RowHolder(view)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
         holder.bind(wordList[position],listener)
    }

    override fun getItemCount(): Int {
        return wordList.count()
    }
}