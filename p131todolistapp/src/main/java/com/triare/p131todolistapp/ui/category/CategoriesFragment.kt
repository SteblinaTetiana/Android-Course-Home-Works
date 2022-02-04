package com.triare.p131todolistapp.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.triare.p131todolist.R
import com.triare.p131todolistapp.data.model.CategoryDbo
import com.triare.p131todolistapp.utils.DateUtils


class CategoriesFragment : Fragment(), CategoriesAdapter.OnItemClickListener {

    private lateinit var categoriesViewModel: CategoriesViewModel
    private lateinit var categoriesAdapter: CategoriesAdapter
    private var category: CategoryDbo? = null
    private var floatingButton: FloatingActionButton? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi()
        initView()
        initViewModel()
    }

    private fun initUi() {
        val recyclerView = view?.findViewById<RecyclerView>(R.id.recycler_view)
        categoriesAdapter =
            CategoriesAdapter(clickListener = this)
        recyclerView?.apply {
            adapter = categoriesAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun initView() {
        floatingButton = view?.findViewById(R.id.floatingActionButton)
        floatingButton?.setOnClickListener {
            findNavController().navigate(R.id.tasksFragment)
        }
    }

    private fun initViewModel() {
        categoriesViewModel = ViewModelProvider(this)[CategoriesViewModel::class.java]

        categoriesViewModel.allCategories.observe(viewLifecycleOwner) {
            categoriesAdapter.listCategories = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.categories_fragment, container, false)
    }

    override fun onClick(category: CategoryDbo) {
        view?.let { list(it) }
    }

    fun list(view: View) {
        CategoriesFragmentDirections.actionCategoriesFragmentToTasksFragment(
        ).also {
            view.findNavController().navigate(it)
        }
    }
}