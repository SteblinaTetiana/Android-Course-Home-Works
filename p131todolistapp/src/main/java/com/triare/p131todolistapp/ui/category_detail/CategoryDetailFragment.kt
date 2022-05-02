package com.triare.p131todolistapp.ui.category_detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.triare.p131todolist.R
import com.triare.p131todolistapp.App
import com.triare.p131todolistapp.data.model.CategoryDbo
import com.triare.p131todolistapp.data.model.TaskDbo
import com.triare.p131todolistapp.ui.categories.CategoriesViewModel
import com.triare.p131todolistapp.utils.DateUtils


class CategoryDetailFragment : Fragment()/*, CreateNoteAdapter.OnItemClickListener*/ {

    private val categoryDetailViewModel by viewModels<CategoryDetailViewModel>()
    private lateinit var categoriesViewModel: CategoriesViewModel
    private lateinit var tasksAdapter: TasksAdapter

    /* private var dataItems: List<TaskDbo>? = null*/
    /*private var listTasks: MutableList<TaskDbo> = mutableListOf()*/
    private var task: TaskDbo? = null
    private var toolbar: MaterialToolbar? = null
    private var floatingButtonCreate: FloatingActionButton? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbar()
        initUi(view)
        initView()
        initViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.categoty_detail_fragment, container, false)
    }

    /*private fun update(dataItems: List<TaskDbo>) {

        if (listTasks == null) {
            listTasks = ArrayList<TaskDbo>()
        }
        listTasks.clear()
        listTasks.addAll(dataItems)

        if (tasksAdapter != null) {
        *//*    tasksAdapter.update(dataItems)*//*
        }
    }*/

    private fun setToolbar() {
        toolbar = view?.findViewById(R.id.toolbar)
        (activity as AppCompatActivity?)?.supportActionBar?.hide()

        toolbar?.inflateMenu(R.menu.menu_edit)

        toolbar?.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        toolbar?.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.edit_note -> {
                    val title = view?.findViewById<EditText>(R.id.title_task)
                    categoriesViewModel.addCategory(
                        id,
                        title?.text.toString(),
                        DateUtils.parseDate()
                    )
                    categoriesViewModel.addCategory(
                        CategoryDbo(
                            id,
                            title?.text.toString(),
                            DateUtils.parseDate()
                        )
                    )
                    task?.let { it -> categoryDetailViewModel.addTask(it) }
                    task?.let { it -> categoryDetailViewModel.addTasks(it) }
                    Toast.makeText(context, "Add Title", Toast.LENGTH_SHORT).show()
                    findNavController().popBackStack()
                    true
                }

                R.id.create_note -> {

                    true
                }

                R.id.delate_note -> {
                    deleteCategory()
                    true
                }
                else -> true
            }
        }
    }

    /* private fun initIntentToMainActivity() {
         startActivity(Intent(context, MainActivity::class.java))
     }*/

    private fun initUi(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_create)
        tasksAdapter = TasksAdapter(/*, clickListener = this*/)

        /*  if (listTasks != null) {
       *//*       tasksAdapter.update(listTasks)*//*
        }*/
        recyclerView?.apply {
            adapter = tasksAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun initView() {
        floatingButtonCreate = view?.findViewById(R.id.floatingActionButton_create)
        floatingButtonCreate?.setOnClickListener {
            saveTask()
        }
    }

    private fun initViewModel() {

        categoriesViewModel = ViewModelProvider(this)[CategoriesViewModel::class.java]

        observeUpdate()
    }

    private fun observeUpdate() {
        categoryDetailViewModel.allTasks.observe(viewLifecycleOwner) {
            /* tasks?.let { listTasks.let { it1 -> tasksAdapter.update(it1) } }*/
            tasksAdapter.listTasks = it

            /*    dataItems?.let { update(it) }*/
        }
    }

    private fun saveTask() {
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
                val text = view?.findViewById<TextView>(R.id.text_checked_view)
                text?.text = userInput.text.toString()
                task?.let {
                    categoryDetailViewModel.addData(
                        it.id,
                        it.categoryId,
                        it.text,
                        it.isFinished
                    )
                }

                task?.let { categoryDetailViewModel.addTask(task!!) }
                task?.let { categoryDetailViewModel.addTasks(task!!) }
                /*  tasksAdapter.update()*/
                /*  if (listTasks != null) {
                  *//*    tasksAdapter.update(listTasks)*//*
                }*/
            }
            ?.setNegativeButton(
                App.context.getString(R.string.cancel)
            ) { dialog, id -> dialog.cancel() }

        val alertDialog: AlertDialog? = alertDialogBuilder?.create()

        alertDialog?.show()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun deleteCategory() {

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
                task?.let { categoryDetailViewModel.deleteByCategory(id) }
                tasksAdapter.notifyDataSetChanged()
                /*initIntentToMainActivity()*/
                findNavController().popBackStack()
            }
            ?.setNegativeButton(
                App.context.getString(R.string.cancel)
            ) { dialog, id -> dialog.cancel() }

        val alertDialog: AlertDialog? = alertDialogBuilder?.create()

        alertDialog?.show()
    }
}