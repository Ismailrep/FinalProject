package com.androProject.finalTask.ui.fragments

import android.os.Bundle
import android.view.View
import com.androProject.finalTask.databinding.FragmentArticleBinding
import com.androProject.finalTask.ui.MainActivity
import com.androProject.finalTask.ui.NewsViewModel

class ArticleFragment :
    ViewBindingFragment<FragmentArticleBinding>(FragmentArticleBinding::inflate) {

    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
    }
}