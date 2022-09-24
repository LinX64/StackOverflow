package com.example.stackoverflow.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stackoverflow.data.model.Item
import com.example.stackoverflow.data.repository.MainRepository
import com.example.stackoverflow.di.IoDispatcher
import com.example.stackoverflow.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRep: MainRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    init {
        getQuestions()
    }

    private var _questionsResponse = MutableLiveData<NetworkResult<List<Item>>>()
    val questionsResponse: LiveData<NetworkResult<List<Item>>> = _questionsResponse

    private fun getQuestions() = viewModelScope.launch(ioDispatcher) {
        val questions = mainRep.getQuestions()
        questions.collect { _questionsResponse.postValue(it) }
    }
}