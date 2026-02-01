package com.project.movienight.application.ports.input

import com.project.movienight.domain.model.User

interface CreateUserUseCase {
    fun create(command: CreateUserCommand): User
}

data class CreateUserCommand(
    val name: String,
    val email: String,
)
