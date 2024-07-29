package com.alvaro.mysimplecleanarchitecture.domain.usecases

import com.alvaro.mysimplecleanarchitecture.domain.entities.MessageEntity
import com.alvaro.mysimplecleanarchitecture.domain.repositories.IMessageRepository

class MessageInteractor(private val messageRepository: IMessageRepository ) : MessageUseCase {
    override fun getMessage(name: String): MessageEntity {
        return messageRepository.getWelcomeMessage(name)
    }
}