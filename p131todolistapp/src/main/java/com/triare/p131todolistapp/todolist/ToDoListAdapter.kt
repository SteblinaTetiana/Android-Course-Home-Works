package com.triare.p131todolistapp.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.triare.p131todolist.R
import com.triare.p131todolistapp.model.ListNoteDvo

class ToDoListAdapter(var listNote: List<ListNoteDvo>, val clickListener: OnItemClickListener) :
    RecyclerView.Adapter<ToDoListAdapter.ListNoteViewHolder>() {

    private var title: TextView? = null
    private var date: TextView? = null
    private var numberNote: TextView? = null

    interface OnItemClickListener {
        fun onClick(listNote: ListNoteDvo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListNoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return ListNoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListNoteViewHolder, position: Int) {
        listNote[position].let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return listNote.size
    }

    inner class ListNoteViewHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {

        init {
            view.setOnClickListener(this)
            initView(view)
        }

        private fun initView(view: View) {
            title = view.findViewById(R.id.title)
            date = view.findViewById(R.id.date)
            numberNote = view.findViewById(R.id.number)
        }

        fun bind(
            listNote: ListNoteDvo
        ) {
            title?.text = listNote.title
            date?.text = listNote.date
            numberNote?.text = listNote.numberNote
        }

        override fun onClick(v: View?) {
            clickListener.onClick(listNote[adapterPosition])
        }
    }
}