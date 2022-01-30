package com.triare.p131todolistapp.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.triare.p131todolist.R
import com.triare.p131todolistapp.data.model.CategoryDbo


class CategoryFragment : Fragment(), CategoryAdapter.OnItemClickListener {

    private lateinit var categoryViewModel: CategoryViewModel
    private lateinit var categoryAdapter: CategoryAdapter
    private var categoryDbo: List<CategoryDbo>? = null
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
        categoryAdapter =
            CategoryAdapter(categoryDbo ?: emptyList(), clickListener = this)
        recyclerView?.apply {
            adapter = categoryAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun initView() {
        floatingButton = view?.findViewById(R.id.floatingActionButton)
        floatingButton?.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
    }

    private fun initViewModel() {
        categoryViewModel = ViewModelProvider(this)[CategoryViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.category_fragment, container, false)
    }

    override fun onClick(category: CategoryDbo) {
        view?.let { categoryViewModel.list(it) }
    }
}