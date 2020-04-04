package com.mindset.spots.view.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration

import androidx.recyclerview.widget.LinearLayoutManager
import com.mindset.spots.R
import com.mindset.spots.model.State
import com.mindset.spots.view.adapter.DashboardListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_home.*


class DashboardFragment : Fragment() {

    private lateinit var viewModel: DashboardViewModel
    private lateinit var newsListAdapter: DashboardListAdapter
    private lateinit var recycler_view: RecyclerView
    private lateinit var txt_error: TextView
    private lateinit var progress_bar: ProgressBar
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        viewModel = ViewModelProviders.of(this)
//            .get(NewsListViewModel::class.java)
//        initAdapter()
//        initState()
//    }

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        recycler_view = root.findViewById(R.id.recycler_view)
        txt_error = root.findViewById(R.id.txt_error)
        progress_bar = root.findViewById(R.id.progress_bar)
        initAdapter()
        initState()

        return root
    }

    private fun initAdapter() {
        newsListAdapter = DashboardListAdapter { viewModel.retry() }
        val layoutManager =  LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recycler_view.layoutManager =layoutManager
        recycler_view.adapter = newsListAdapter
        val dividerItemDecoration = DividerItemDecoration(
            recycler_view.getContext(),
            layoutManager.orientation
        )
        recycler_view.addItemDecoration(dividerItemDecoration)
        viewModel.newsList.observe(this, Observer {
            newsListAdapter.submitList(it)
        })
    }

    private fun initState() {
        txt_error.setOnClickListener { viewModel.retry() }
        viewModel.getState().observe(this, Observer { state ->
            progress_bar.visibility = if (viewModel.listIsEmpty() && state == State.LOADING) View.VISIBLE else View.GONE
            txt_error.visibility = if (viewModel.listIsEmpty() && state == State.ERROR) View.VISIBLE else View.GONE
            if (!viewModel.listIsEmpty()) {
                newsListAdapter.setState(state ?: State.DONE)
            }
        })
    }

}
