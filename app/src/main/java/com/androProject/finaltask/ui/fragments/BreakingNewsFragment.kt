package com.androProject.finalTask.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.androProject.finalTask.adapters.NewsAdapter
import com.androProject.finalTask.databinding.FragmentBreakingNewsBinding
import com.androProject.finalTask.ui.MainActivity
import com.androProject.finalTask.ui.NewsViewModel
import com.androProject.finalTask.util.Constants.Companion.BREAKING_NEWS_FRAGMENT_TAG
import com.androProject.finalTask.util.Resource

class BreakingNewsFragment :
    ViewBindingFragment<FragmentBreakingNewsBinding>(FragmentBreakingNewsBinding::inflate) {

    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel

        setupRecyclerView()

        viewModel.breakingNews.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { newsResponse ->
                        newsAdapter.differ.submitList(newsResponse.articles)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { message ->
                        Log.e(BREAKING_NEWS_FRAGMENT_TAG, "Error: $message")
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        }
    }

    private fun hideProgressBar() {
        binding.paginationProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        binding.paginationProgressBar.visibility = View.VISIBLE
    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        binding.rvBreakingNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}