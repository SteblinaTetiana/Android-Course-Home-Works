package com.triare.p131todolistapp.ui.createnote

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.triare.p131todolist.R

class CreateNoteFragment : Fragment() {

    companion object {
        fun newInstance() = CreateNoteFragment()
    }

    /*private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result: ActivityResult ->

            when (result.resultCode) {
                NameActivity.REQUEST_NAME -> {
                    findViewById<TextView>(R.id.textview_name).text =
                        result.data?.getStringExtra("NAME")
                }
            }
        }*/

    private var viewModel: CreateNoteViewModel? = null
    private var createNoteFragment: View? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.create_note_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[CreateNoteViewModel::class.java]
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
            R.id.create -> {
                /*  val intentName = Intent(this, ToDoListFragment::class.java)
                  startForResult.launch(intentName)*/
                true
            }
            R.id.edit -> true

        }
        return super.onOptionsItemSelected(item)
    }
}