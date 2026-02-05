package ru.tbank.education.school.lesson5.service

import org.springframework.stereotype.Service
import ru.tbank.education.school.lesson5.dto.CreateUserRequest
import ru.tbank.education.school.lesson5.dto.User

@Service
class UserService {

    private val users = mutableMapOf<Long, User>()
    private var idCounter = 1L

    fun findAll(): List<User> =
        users.values.toList()

    fun findById(id: Long): User =
        users[id] ?: throw NoSuchElementException("User not found")

    fun create(request: CreateUserRequest): User {
        val user = User(
            id = idCounter++,
            name = request.name,
            email = request.email
        )
        users[user.id] = user
        return user
    }

    fun update(id: Long, request: CreateUserRequest): User {
        if (!users.containsKey(id)) {
            throw NoSuchElementException("User not found")
        }
        val updated = User(id, request.name, request.email)
        users[id] = updated
        return updated
    }

    fun delete(id: Long) {
        users.remove(id) ?: throw NoSuchElementException("User not found")
    }
}
