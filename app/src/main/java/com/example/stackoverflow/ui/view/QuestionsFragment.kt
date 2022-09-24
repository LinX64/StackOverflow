package com.example.stackoverflow.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import com.example.stackoverflow.R
import com.example.stackoverflow.data.model.Item
import com.example.stackoverflow.databinding.FragmentQuestionsBinding
import com.example.stackoverflow.ui.adapter.QuestionsAdapter
import com.example.stackoverflow.ui.viewmodel.MainViewModel
import com.example.stackoverflow.util.NetworkResult
import com.example.stackoverflow.util.inVisible
import com.example.stackoverflow.util.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuestionsFragment : Fragment(R.layout.fragment_questions) {

    private lateinit var binding: FragmentQuestionsBinding
    private val mainViewModel by activityViewModels<MainViewModel>()
    private val questionsAdapter by lazy { QuestionsAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentQuestionsBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner

        setupUI()
        setupObserver()
    }

    private fun setupUI() {
        binding.recyclerView.adapter = questionsAdapter
    }

    private fun setupObserver() {
        mainViewModel.questionsResponse.observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResult.Success -> {
                    binding.progressBar.inVisible()
                    setQuestions(it.data)
                }
                is NetworkResult.Error -> {
                    Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                    binding.progressBar.inVisible()
                }
                is NetworkResult.Loading -> binding.progressBar.visible()
            }
        }
    }

    private fun setQuestions(questions: List<Item>) {
        questionsAdapter.setData(questions)
    }
}