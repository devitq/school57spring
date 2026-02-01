package com.project.movienight.application.services

import com.project.movienight.adapters.persistence.inmemory.UserRepositoryAdapter
import com.project.movienight.application.ports.input.CreateUserCommand
import com.project.movienight.application.ports.input.CreateUserUseCase
import com.project.movienight.application.ports.output.IdGenerator
import com.project.movienight.domain.model.User
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepositoryAdapter,
    private val idGenerator: IdGenerator,
) : CreateUserUseCase {
    override fun create(command: CreateUserCommand): User =
        userRepository.save(
            User(
                id = idGenerator.generateId(),
                name = command.name,
                email = command.email,
                library = null,
            ),
        )
}
