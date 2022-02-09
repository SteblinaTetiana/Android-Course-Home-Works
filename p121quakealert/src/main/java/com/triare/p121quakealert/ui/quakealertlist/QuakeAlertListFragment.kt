package com.triare.p121quakealert.ui.quakealertlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.triare.p121quakealert.R
import com.triare.p121quakealert.ui.model.FeatureDvo

class QuakeAlertListFragment : Fragment() {

    private val viewModel by viewModels<QuakeAlertListViewModel>()
    private lateinit var quakeAlertAdapter: QuakeAlertAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi()
        observeUpdate()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.quake_alert_list_fragment, container, false)
    }

    private fun initUi() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val recyclerView = view?.findViewById<RecyclerView>(R.id.recycler_view)
        val clickListener = object : QuakeAlertAdapter.OnItemClickListener {
            override fun onClick(feature: FeatureDvo) {
                view?.let { viewModel.list(it, feature) }
            }
        }
        quakeAlertAdapter =
            QuakeAlertAdapter(clickListener = clickListener)
        recyclerView?.apply {
            adapter = quakeAlertAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun observeUpdate() {
        observeQuakeAlertResult()
    }

    private fun observeQuakeAlertResult() {
        viewModel.quakeAlertResult.observe(viewLifecycleOwner) {
            quakeAlertAdapter.features = it?.features ?: listOf()
            quakeAlertAdapter.notifyDataSetChanged()
        }
    }
}