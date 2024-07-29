package com.alvaro.mysimplecleanarchitecture.data

import com.alvaro.mysimplecleanarchitecture.domain.repositories.IMessageRepository

class MessageRepository(private val messageDataSource: IMessageDataSource) : IMessageRepository {
    override fun getWelcomeMessage(name: String) = messageDataSource.getMessageFromSource(name)
}