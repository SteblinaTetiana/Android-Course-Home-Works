package com.triare.p121quakealert.quakealertlist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.triare.p121quakealert.R

class QuakeAlertListFragment : Fragment() {

    companion object {
        fun newInstance() = QuakeAlertListFragment()
    }

    private lateinit var viewModel: QuakeAlertListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.quake_alert_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(QuakeAlertListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}