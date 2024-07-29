package com.alvaro.mysimplecleanarchitecture.data

import com.alvaro.mysimplecleanarchitecture.domain.entities.MessageEntity

interface IMessageDataSource {
    fun getMessageFromSource(name: String): MessageEntity
}