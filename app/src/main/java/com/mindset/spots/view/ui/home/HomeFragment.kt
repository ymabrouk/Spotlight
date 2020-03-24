package com.mindset.spots.view.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import com.mindset.spots.databinding.FragmentHomeBinding
import com.mindset.spots.view.adapter.NewsListAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.longToast
class HomeFragment : Fragment() {

    private lateinit var adapter: NewsListAdapter
    private lateinit var viewDataBinding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        viewDataBinding = FragmentHomeBinding.inflate(inflater, container, false).apply {
            viewmodel = ViewModelProviders.of(this@HomeFragment).get(HomeViewModel::class.java)
            setLifecycleOwner(viewLifecycleOwner)
        }

        return viewDataBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.viewmodel?.fetchRepoList()
        setupAdapter()
        setupObservers()

    }

    private fun setupObservers() {

        viewDataBinding.viewmodel?.feedsListLive?.observe(viewLifecycleOwner, Observer {
            adapter.updateRepoList(it)
        })

        viewDataBinding.viewmodel?.toastMessage?.observe(viewLifecycleOwner, Observer {
            activity?.longToast(it)
        })
    }

    private fun setupAdapter() {
            adapter = NewsListAdapter()
            val layoutManager = LinearLayoutManager(activity)
            repo_list_rv.layoutManager = layoutManager
            repo_list_rv.addItemDecoration(DividerItemDecoration(activity, layoutManager.orientation))
            repo_list_rv.adapter = adapter

    }

}