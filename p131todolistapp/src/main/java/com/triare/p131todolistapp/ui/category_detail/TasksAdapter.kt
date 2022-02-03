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
import java.util.*

class TasksAdapter :
    RecyclerView.Adapter<TasksAdapter.TasksViewHolder>() {

    var text: TextView? = null
    var isFinished: CheckBox? = null
    var buttonDelete: ImageButton? = null
    private var categoryDetailViewModel: CategoryDetailViewModel? = null
    private var database: AppDatabase? = null
    private var listTasks: MutableList<TaskDbo> = mutableListOf()

    /*interface OnItemClickListener {
        fun onClick(task: TaskDbo)
    }
*/
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

    fun update(dataItemList: List<TaskDbo>) {
        /*list.clear()*/
        /* database?.taskDao()?.getTasks(categoryId = 0)?.let { list.addAll(it) }*/
        /*   notifyDataSetChanged()*/
        if (listTasks == null) {
            listTasks = ArrayList<TaskDbo>()
        }
        listTasks.clear()
        listTasks.addAll(dataItemList)
        notifyDataSetChanged()
    }

    inner class TasksViewHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {

        init {
            view.setOnClickListener(this)
            initView(view)
        }

        private fun initView(view: View) {
            text = view.findViewById(R.id.text_checked_view)
            isFinished = view.findViewById(R.id.checkBox_create_note)
            buttonDelete = view.findViewById(R.id.button_delete)
        }

        fun bind(
            listTask: TaskDbo
        ) {

            database = AppDatabase.getInstance()
            database!!.taskDao().updateTask(0, text.toString());
            text?.text = listTask.text
            try {
                if (isFinished != null) {
                    isFinished!!.isChecked = true
                    text?.paintFlags = text?.paintFlags?.or(Paint.STRIKE_THRU_TEXT_FLAG)!!
                } else {
                    isFinished!!.isChecked = false
                    isFinished?.paintFlags =
                        isFinished?.paintFlags?.and(Paint.STRIKE_THRU_TEXT_FLAG.inv())!!
                }
            } catch (e: NullPointerException) {
            }

            buttonDelete?.setOnClickListener {
                categoryDetailViewModel?.delete(listTask.id)
            }
        }


        override fun onClick(v: View?) {
            /*clickListener.onClick(listTasks[adapterPosition])*/
        }
    }
}