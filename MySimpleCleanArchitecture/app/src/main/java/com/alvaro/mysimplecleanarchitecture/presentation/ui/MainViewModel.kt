package com.alvaro.mysimplecleanarchitecture.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alvaro.mysimplecleanarchitecture.domain.entities.MessageEntity
import com.alvaro.mysimplecleanarchitecture.domain.usecases.MessageUseCase
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel(private val messageUseCase: MessageUseCase) : ViewModel() {
    private val _message = MutableStateFlow<MessageEntity>(MessageEntity(""))
    val message
        get() = _message

    init {
        setName("Alvaro")
    }
    fun setName(name: String) {
        _message.value = messageUseCase.getMessage(name)
    }
}