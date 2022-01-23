package com.triare.p131todolistapp.todolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.triare.p131todolist.R
import com.triare.p131todolistapp.model.ListNoteDvo

class ToDoListFragment : Fragment(), ToDoListAdapter.OnItemClickListener {

    private val viewModel by viewModels<ToDoListViewModel>()
    private lateinit var toDoListAdapter: ToDoListAdapter
    private var listNote: List<ListNoteDvo>? = null
    private var floatingButton: FloatingActionButton? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi()
        initView(view)
        /* viewModel.toDoListResult.observe(viewLifecycleOwner) {
             toDoListAdapter.listNote = it ?: listOf()
             toDoListAdapter.notifyDataSetChanged()
         }*/
    }

    private fun initView(view: View) {
        floatingButton = view.findViewById(R.id.floatingActionButton)
      /*  floatingButton.setOnClickListener {
        }*/
    }

    private fun initUi() {
        val recyclerView = view?.findViewById<RecyclerView>(R.id.recycler_view)
        toDoListAdapter =
            ToDoListAdapter(listNote ?: emptyList(), clickListener = this)
        recyclerView?.apply {
            adapter = toDoListAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.to_do_list_fragment, container, false)
    }

    override fun onClick(listNote: ListNoteDvo) {
        /* view?.let { viewModel.list(it, listNote) }*/
    }
}