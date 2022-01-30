package com.triare.p131todolistapp.ui.tasks

import android.os.Build
import android.os.Bundle
import android.view.*
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.triare.p131todolist.R
import com.triare.p131todolistapp.data.db.dao.TaskDao
import com.triare.p131todolistapp.data.model.TaskDbo


class TasksFragment : Fragment()/*, CreateNoteAdapter.OnItemClickListener*/ {

    private lateinit var tasksViewModel: TasksViewModel
    private lateinit var tasksAdapter: TasksAdapter
    private var taskDbo: List<TaskDbo>? = null
    private var task: TaskDbo? = null
    private var floatingButtonCreate: FloatingActionButton? = null
    private var taskDao: TaskDao? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi(view)
        initView()
        initViewModel()

       /* val toolbar: Toolbar = view.findViewById(R.id.toolbar)
        toolbar.inflateMenu(R.menu.menu_edit)

        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.edit_note -> isAdded
            }
            true

        }*/

        val tb = view.findViewById(R.id.toolbar) as Toolbar?
        tb?.inflateMenu(R.menu.menu_edit)
        tb?.setOnMenuItemClickListener { item -> onOptionsItemSelected(item) }
    }

    private fun initUi(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_create)
        tasksAdapter =
            TasksAdapter(taskDbo ?: emptyList()/*, clickListener = this*/)
        recyclerView?.apply {
            adapter = tasksAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun initView() {
        floatingButtonCreate = view?.findViewById(R.id.floatingActionButton_create)
        floatingButtonCreate?.setOnClickListener {
            alertDialog()
        }
    }

    private fun initViewModel() {
        tasksViewModel = ViewModelProvider(this)[TasksViewModel::class.java]
    }

    private fun alertDialog() {
        val layoutInflater = LayoutInflater.from(context)
        val dialogLayout: View = layoutInflater.inflate(R.layout.alert_dialog, null)
        val alertDialogBuilder = context?.let {
            MaterialAlertDialogBuilder(
                it, R.style.ThemeOverlay_App_MaterialAlertDialog
            )
        }

        alertDialogBuilder?.setView(dialogLayout)
        val userInput = dialogLayout.findViewById(R.id.etAlertDialog) as EditText

        alertDialogBuilder
            ?.setCancelable(false)
            ?.setPositiveButton(
                "Додати"
            ) { dialog, id ->
                /* task?.let { taskDao?.insert(it) }*/
                val text: TextView? = view?.findViewById(R.id.text_checked_view)

                tasksAdapter.text?.text = userInput.text.toString()
                tasksViewModel.addTasks()
            }
            ?.setNegativeButton(
                "Відмінити"
            ) { dialog, id -> dialog.cancel() }

        val alertDialog: AlertDialog? = alertDialogBuilder?.create()

        alertDialog?.show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.task_fragment, container, false)
    }

/*    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val tb = view?.findViewById(R.id.toolbar) as Toolbar
            tb.inflateMenu(R.menu.menu_edit)
            tb.setOnMenuItemClickListener { item -> onOptionsItemSelected(item!!) }
        } else {
            inflater.inflate(R.menu.menu_edit, menu)

        }
    }*/
      override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
          inflater.inflate(R.menu.menu_edit, menu)
      }

    override fun onPrepareOptionsMenu(menu: Menu) {

        /* val createNoteFragment = findViewById<View>(R.id.create_note_fragment)*/
        /*val buttonPlants=findViewById<RadioButton>(R.id.plants)
*/
        /* createNoteFragment = findViewById(R.id.create_note_fragment)
         createNoteFragment?.isVisible?.let { menu.setGroupVisible(R.id.create_note, it) }*/
        /* menu?.setGroupVisible(R.id.group_plants, buttonPlants.isChecked)*/

        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.create_note -> {
                /*  val intentName = Intent(this, ToDoListFragment::class.java)
                  startForResult.launch(intentName)*/
                true
            }
            R.id.delate_note -> true

        }
        return super.onOptionsItemSelected(item)

    }

    /* override fun onClick(task: TaskDbo) {
         TODO("Not yet implemented")
     }*/

}