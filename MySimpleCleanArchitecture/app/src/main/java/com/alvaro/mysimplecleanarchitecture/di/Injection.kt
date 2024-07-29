package com.alvaro.mysimplecleanarchitecture.di

import com.alvaro.mysimplecleanarchitecture.data.IMessageDataSource
import com.alvaro.mysimplecleanarchitecture.data.MessageDataSource
import com.alvaro.mysimplecleanarchitecture.data.MessageRepository
import com.alvaro.mysimplecleanarchitecture.domain.repositories.IMessageRepository
import com.alvaro.mysimplecleanarchitecture.domain.usecases.MessageInteractor
import com.alvaro.mysimplecleanarchitecture.domain.usecases.MessageUseCase

object Injection {
    fun provideUseCase(): MessageUseCase {
        val messageRepository = provideRepository()
        return MessageInteractor(messageRepository)
    }

    private fun provideRepository(): IMessageRepository {
        val messageDataSource = provideDataSource()
        return MessageRepository(messageDataSource)
    }

    private fun provideDataSource(): IMessageDataSource {
        return MessageDataSource()
    }
}