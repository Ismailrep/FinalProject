package com.androProject.finalTask.ui.fragments

import android.os.Bundle
import android.view.View
import com.androProject.finalTask.databinding.FragmentSavedNewsBinding
import com.androProject.finalTask.ui.MainActivity
import com.androProject.finalTask.ui.NewsViewModel

class SavedNewsFragment :
    ViewBindingFragment<FragmentSavedNewsBinding>(FragmentSavedNewsBinding::inflate) {

    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
    }
}