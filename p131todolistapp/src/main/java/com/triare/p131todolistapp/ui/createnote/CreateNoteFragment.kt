package com.triare.p131todolistapp.ui.createnote

import android.os.Bundle
import android.view.*
import android.view.LayoutInflater
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.triare.p131todolist.R
import com.triare.p131todolistapp.data.db.dao.TaskDao
import com.triare.p131todolistapp.data.model.TaskDbo


class CreateNoteFragment : Fragment(), CreateNoteAdapter.OnItemClickListener {


    private var viewModel: CreateNoteViewModel? = null
    private lateinit var createNoteAdapter: CreateNoteAdapter
    private var taskDbo: List<TaskDbo>? = null
    private var task: TaskDbo? = null
    private var floatingButtonCreate: FloatingActionButton? = null
    private var taskDao: TaskDao? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        initView()
    }

    private fun initUi() {
        val recyclerView = view?.findViewById<RecyclerView>(R.id.recycler_view_create)
        createNoteAdapter =
            CreateNoteAdapter(taskDbo ?: emptyList(), clickListener = this)
        recyclerView?.apply {
            adapter = createNoteAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun initView() {
        floatingButtonCreate = view?.findViewById(R.id.floatingActionButton_create)
        floatingButtonCreate?.setOnClickListener {
            alertDialog()
        }
    }

    fun alertDialog() {
        val li = LayoutInflater.from(context)
        val promptsView: View = li.inflate(R.layout.alert_dialog, null)
        val alertDialogBuilder = context?.let {
            MaterialAlertDialogBuilder(
                it, R.style.ThemeOverlay_App_MaterialAlertDialog
            )
        }

        alertDialogBuilder?.setView(promptsView)
        val userInput = promptsView.findViewById(R.id.etAlertDialog) as EditText

        alertDialogBuilder
            ?.setCancelable(false)
            ?.setPositiveButton(
                "Додати"
            ) { dialog, id ->
                task?.let { taskDao?.insert(it) }
                userInput.text
                /*val replyIntent = Intent()
                val word = userInput.text.toString()

                if (TextUtils.isEmpty(word)) {
                    setResult(Fragment.RESULT_CANCELED, replyIntent)
                } else {

                    replyIntent.putExtra(EXTRA_REPLY, word)
                    setResult(Fragment.RESULT_OK, replyIntent)
                }
                finish()
*/
                /* Toast.makeText(
                     context,
                     "Entered: " + userInput.text.toString(),
                     Toast.LENGTH_LONG
                 ).show()*/
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
        return inflater.inflate(R.layout.create_note_fragment, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_create, menu)
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

    override fun onClick(task: TaskDbo) {
        TODO("Not yet implemented")
    }
}