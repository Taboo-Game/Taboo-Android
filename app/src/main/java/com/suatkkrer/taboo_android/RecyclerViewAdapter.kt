package com.suatkkrer.taboo_android

import android.net.sip.SipSession
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.word_list.view.*

class RecyclerViewAdapter(private val wordList: ArrayList<WordModel>, private val listener: Listener) : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {

    inner class RowHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        fun bind(wordModel: WordModel, listener: Listener) {

            itemView.recyclerText.text = wordModel.anaKelime
            itemView.recyclerImage.setImageResource(R.drawable.dictionary)
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface Listener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.word_list, parent, false)
            return RowHolder(view)
        }

        override fun onBindViewHolder(holder: RowHolder, position: Int) {
            holder.bind(wordList[position], listener)
        }

        override fun getItemCount(): Int {
            return wordList.count()
        }
    }
