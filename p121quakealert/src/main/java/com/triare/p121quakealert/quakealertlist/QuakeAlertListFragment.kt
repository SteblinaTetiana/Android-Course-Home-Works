package com.triare.p121quakealert.quakealertlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.triare.p121quakealert.R
import com.triare.p121quakealert.model.QuakeAlert

class QuakeAlertListFragment : Fragment() {

    companion object {
        fun newInstance() = QuakeAlertListFragment()
    }

    private val viewModel by viewModels<QuakeAlertListViewModel>()

    private lateinit var quakeAlertAdapter: QuakeAlertAdapter
    private var quakeAlert: QuakeAlert? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        quakeAlertAdapter = QuakeAlertAdapter(quakeAlert?.features ?: emptyList())
        recyclerView.apply {
            adapter = quakeAlertAdapter
            layoutManager = LinearLayoutManager(activity)

        }
        viewModel.quakeAlertResult.observe(viewLifecycleOwner) {
            quakeAlertAdapter.features = it?.features ?: listOf()
            quakeAlertAdapter.notifyDataSetChanged()

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.quake_alert_list_fragment, container, false)
    }



}