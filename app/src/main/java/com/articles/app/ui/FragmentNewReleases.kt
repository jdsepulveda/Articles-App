package com.articles.app.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.articles.app.utils.Status
import com.articles.R
import com.articles.app.adapter.NewReleasesAdapter
import com.articles.app.utils.gone
import com.articles.app.utils.visible
import com.articles.app.viewmodels.FragmentNewReleasesVM
import com.articles.databinding.FragmentNewReleasesBinding
import kotlinx.android.synthetic.main.fragment_new_releases.*
import org.koin.android.viewmodel.ext.android.viewModel

class FragmentNewReleases : Fragment() {

    private val fragmentNewReleasesVM: FragmentNewReleasesVM by viewModel()

    private lateinit var newReleasesAdapter: NewReleasesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return DataBindingUtil.inflate<ViewDataBinding>(
            layoutInflater, R.layout.fragment_new_releases, container, false
        ).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DataBindingUtil.findBinding<FragmentNewReleasesBinding>(view)?.apply {
            lifecycleOwner = viewLifecycleOwner
        }

        initRecyclerView()
        setUpDataObservers()
    }

    private fun initRecyclerView() {
        newReleasesAdapter = NewReleasesAdapter()
        rvNewReleases.layoutManager = LinearLayoutManager(this.context, RecyclerView.HORIZONTAL, false)
        rvNewReleases.adapter = newReleasesAdapter
    }

    private fun setUpDataObservers() {
        fragmentNewReleasesVM.newReleases.observe(viewLifecycleOwner, Observer {
            when(it.status) {
                Status.LOADING -> {
                    progressBarLoading.visible()
                }
                Status.SUCCESS -> {
                    progressBarLoading.gone()
                    it.data.orEmpty().let { articles ->
                        newReleasesAdapter.populate(articles)
                    }
                }
                Status.ERROR -> {
                    progressBarLoading.gone()
                }
            }
        })
    }
}