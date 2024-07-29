package com.alvaro.mysimplecleanarchitecture.data

import com.alvaro.mysimplecleanarchitecture.domain.entities.MessageEntity

class MessageDataSource : IMessageDataSource {
    override fun getMessageFromSource(name: String) = MessageEntity("Hello $name! Welcome to Clean Architecture")
}