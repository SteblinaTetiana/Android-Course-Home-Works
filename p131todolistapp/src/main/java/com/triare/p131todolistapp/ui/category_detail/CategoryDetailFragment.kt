package com.triare.p131todolistapp.ui.category_detail

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.triare.p131todolist.R
import com.triare.p131todolistapp.App
import com.triare.p131todolistapp.data.db.dao.TaskDao
import com.triare.p131todolistapp.data.model.TaskDbo
import com.triare.p131todolistapp.ui.MainActivity


class CategoryDetailFragment : Fragment()/*, CreateNoteAdapter.OnItemClickListener*/ {

    private lateinit var categoryDetailViewModel: CategoryDetailViewModel
    private lateinit var tasksAdapter: TasksAdapter
    private var taskDbo: List<TaskDbo>? = null
    private var task: TaskDbo? = null
    private var toolbar: MaterialToolbar? = null
    private var floatingButtonCreate: FloatingActionButton? = null
    private var taskDao: TaskDao? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi(view)
        initView()
        initViewModel()

        setToolbar()
    }

    private fun setToolbar() {
        toolbar = view?.findViewById(R.id.toolbar)

        toolbar?.inflateMenu(R.menu.menu_edit)

        toolbar?.setNavigationOnClickListener {
            startActivity(Intent(context, MainActivity::class.java))
        }
        onToolbarMenuItemSelected()
    }

    private fun initUi(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_create)
        tasksAdapter = TasksAdapter(/*, clickListener = this*/)
        recyclerView?.apply {
            adapter = tasksAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun initView() {
        floatingButtonCreate = view?.findViewById(R.id.floatingActionButton_create)
        floatingButtonCreate?.setOnClickListener {
            alertDialogAdd()
        }
    }

    private fun initViewModel() {
        categoryDetailViewModel = ViewModelProvider(this)[CategoryDetailViewModel::class.java]

        categoryDetailViewModel.allTasks.observe(viewLifecycleOwner) { tasks ->
            tasks?.let { tasksAdapter.setTasks(it) }
        }
    }

    private fun alertDialogAdd() {
        val layoutInflater = LayoutInflater.from(context)
        val dialogLayout: View = layoutInflater.inflate(R.layout.alert_dialog_add, null)
        val alertDialogBuilder = context?.let {
            MaterialAlertDialogBuilder(it, R.style.ThemeOverlay_App_MaterialAlertDialog)
        }

        alertDialogBuilder?.setView(dialogLayout)
        val userInput = dialogLayout.findViewById(R.id.etAlertDialog) as EditText

        alertDialogBuilder
            ?.setCancelable(false)
            ?.setPositiveButton(
                App.context.getString(R.string.add)
            ) { dialog, id ->
                tasksAdapter.text?.text = userInput.text.toString()
                task?.let { categoryDetailViewModel.addTasks(task!!) }
                /* tasksViewModel.updateTask(0, text = "00000");*/
                tasksAdapter.update()
            }
            ?.setNegativeButton(
                App.context.getString(R.string.cancel)
            ) { dialog, id -> dialog.cancel() }

        val alertDialog: AlertDialog? = alertDialogBuilder?.create()

        alertDialog?.show()
    }

    private fun alertDialogDelete() {

        val layoutInflater = LayoutInflater.from(context)
        val dialogLayout: View = layoutInflater.inflate(R.layout.alert_dialog_delete, null)
        val alertDialogBuilder = context?.let {
            MaterialAlertDialogBuilder(it, R.style.ThemeOverlay_App_MaterialAlertDialog)
        }

        alertDialogBuilder?.setView(dialogLayout)
        alertDialogBuilder
            ?.setCancelable(false)
            ?.setPositiveButton(
                getString(R.string.delete)
            ) { dialog, id ->
                task?.let { categoryDetailViewModel.delete(id) }
                tasksAdapter.notifyDataSetChanged()
            }
            ?.setNegativeButton(
                App.context.getString(R.string.cancel)
            ) { dialog, id -> dialog.cancel() }

        val alertDialog: AlertDialog? = alertDialogBuilder?.create()

        alertDialog?.show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.categoty_detail_fragment, container, false)
    }

    private fun onToolbarMenuItemSelected() {
        toolbar?.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.edit_note -> {
                    /*  item.isVisible = isEditing*/
                    /*  val intentName = Intent(this, ToDoListFragment::class.java)
                      startForResult.launch(intentName)*/
                    categoryDetailViewModel.addTitle(0, title = "add title")
                    Toast.makeText(context, "Add Title", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.create_note -> {

                    true
                }

                R.id.delate_note -> {
                    alertDialogDelete()
                    true
                }
                else -> true
            }
        }
    }

}