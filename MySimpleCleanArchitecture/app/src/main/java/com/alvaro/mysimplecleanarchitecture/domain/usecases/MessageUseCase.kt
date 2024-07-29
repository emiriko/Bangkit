package com.alvaro.mysimplecleanarchitecture.domain.usecases

import com.alvaro.mysimplecleanarchitecture.domain.entities.MessageEntity

interface MessageUseCase {
    fun getMessage(name: String): MessageEntity
}