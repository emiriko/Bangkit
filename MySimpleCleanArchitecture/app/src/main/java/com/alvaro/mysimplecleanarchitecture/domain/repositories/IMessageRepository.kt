package com.alvaro.mysimplecleanarchitecture.domain.repositories

import com.alvaro.mysimplecleanarchitecture.domain.entities.MessageEntity

interface IMessageRepository {
    fun getWelcomeMessage(name: String): MessageEntity
}