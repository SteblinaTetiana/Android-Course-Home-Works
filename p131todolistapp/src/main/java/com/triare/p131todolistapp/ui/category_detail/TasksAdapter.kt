package com.triare.p131todolistapp.ui.category_detail

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.triare.p131todolist.R
import com.triare.p131todolistapp.data.db.AppDatabase
import com.triare.p131todolistapp.data.model.TaskDbo

class TasksAdapter :
    RecyclerView.Adapter<TasksAdapter.TasksViewHolder>() {

    private var categoryDetailViewModel: CategoryDetailViewModel? = null
    private var database: AppDatabase? = null
    /*  private var listTasks: MutableList<TaskDbo> = mutableListOf()*/

    var listTasks: List<TaskDbo> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.task_list_item, parent, false)
        return TasksViewHolder(view)
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        listTasks[position].let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return listTasks.size
    }


    inner class TasksViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        /*    init {
                view.setOnClickListener(this)
                initView(view)
            }*/

        /* private fun initView(view: View) {
           *//*  text = view.findViewById(R.id.text_checked_view)*//*
            var isFinished = view.findViewById<CheckBox>(R.id.checkBox_create_note)
            *//*buttonDelete = view.findViewById(R.id.button_delete)*//*
        }*/

        fun bind(
            listTask: TaskDbo
        ) {
            val isFinished = view.findViewById<CheckBox>(R.id.checkBox_create_note)
            val text = view.findViewById<TextView>(R.id.text_checked_view)
            val buttonDelete = view.findViewById<ImageButton>(R.id.button_delete)
            /*database = AppDatabase.getInstance()
            database!!.taskDao().updateTask(0, text.toString());*/
            text.text = listTask.text
            try {

                if (isFinished != null) {
                    isFinished.isChecked = false
                    isFinished.paintFlags =
                        isFinished.paintFlags.and(Paint.STRIKE_THRU_TEXT_FLAG.inv())
                } else {
                    isFinished?.isChecked = true
                    text?.paintFlags = text?.paintFlags?.or(Paint.STRIKE_THRU_TEXT_FLAG)!!
                }
            } catch (e: NullPointerException) {
            }

            buttonDelete?.setOnClickListener {
                categoryDetailViewModel?.delete(listTask.id)
            }
        }
    }
}