package com.triare.p131todolistapp.ui.createnote

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.triare.p131todolist.R
import com.triare.p131todolistapp.data.model.TaskDbo

class CreateNoteAdapter(var listTasks: List<TaskDbo>, val clickListener: OnItemClickListener) :
    RecyclerView.Adapter<CreateNoteAdapter.CreateNoteViewHolder>() {

    private var text: TextView? = null
    private var isFinished: CheckBox? = null

    interface OnItemClickListener {
        fun onClick(task: TaskDbo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreateNoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.create_list_item, parent, false)
        return CreateNoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: CreateNoteViewHolder, position: Int) {
        listTasks[position].let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return listTasks.size
    }

    inner class CreateNoteViewHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {

        init {
            view.setOnClickListener(this)
            initView(view)
        }

        private fun initView(view: View) {
            text = view.findViewById(R.id.title)
            isFinished = view.findViewById(R.id.checkBox_create_note)
        }

        fun bind(
            listTask: TaskDbo
        ) {
            text?.text = listTask.text
           /* isFinished?.text = listTask.isFinished*/
        }

        override fun onClick(v: View?) {
            clickListener.onClick(listTasks[adapterPosition])
        }
    }
}