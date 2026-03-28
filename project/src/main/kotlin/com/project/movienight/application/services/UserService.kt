package com.project.movienight.application.services

import com.project.movienight.application.ports.input.CreateUserCommand
import com.project.movienight.application.ports.input.CreateUserUseCase
import com.project.movienight.application.ports.input.DeleteUserUseCase
import com.project.movienight.application.ports.input.EditUserCommand
import com.project.movienight.application.ports.input.EditUserUseCase
import com.project.movienight.application.ports.input.ListUserUseCase
import com.project.movienight.application.ports.input.ReadUserUseCase
import com.project.movienight.application.ports.output.IdGenerator
import com.project.movienight.application.ports.output.UserRepositoryPort
import com.project.movienight.config.UserServiceProperties
import com.project.movienight.domain.model.User
import org.springframework.stereotype.Service
import java.util.UUID

@Service("userService")
class UserService(
    private val userRepository: UserRepositoryPort,
    private val idGenerator: IdGenerator,
    private val userConfig: UserServiceProperties,
) : CreateUserUseCase,
    ReadUserUseCase,
    EditUserUseCase,
    DeleteUserUseCase,
    ListUserUseCase {

    override fun create(command: CreateUserCommand): User {
        validateUserName(command.name)

        val user = User(
            id = idGenerator.generateId(),
            name = command.name,
            email = command.email,
            library = null,
        )

        return userRepository.save(user)
    }

    override fun read(id: UUID): User? = userRepository.findById(id)

    override fun edit(id: UUID, command: EditUserCommand): User {
        validateUserName(command.name)

        val existingUser = userRepository.findById(id)
            ?: throw IllegalArgumentException("User with id $id not found")

        val updatedUser = existingUser.copy(name = command.name)

        return userRepository.save(updatedUser)
    }

    override fun delete(id: UUID) {
        userRepository.findById(id)
            ?: throw IllegalArgumentException("User with id $id not found")

        userRepository.deleteById(id)
    }

    override fun list(): List<User> = userRepository.findAll()

    private fun validateUserName(name: String) {
        if (userConfig.isBlocked(name)) {
            throw IllegalArgumentException("User with this name is not acceptable")
        }
    }
}
