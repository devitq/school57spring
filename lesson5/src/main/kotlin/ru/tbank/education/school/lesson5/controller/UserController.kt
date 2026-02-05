package ru.tbank.education.school.lesson5.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.tbank.education.school.lesson5.dto.CreateUserRequest
import ru.tbank.education.school.lesson5.dto.User
import ru.tbank.education.school.lesson5.service.UserService

@RestController
@RequestMapping("/api/users")
@Tag(name = "Users", description = "CRUD operations for users")
class UserController(
    private val userService: UserService
) {

    @GetMapping
    @Operation(summary = "Get all users")
    fun getAll(): List<User> =
        userService.findAll()

    @GetMapping("/{id}")
    @Operation(summary = "Get user by id")
    fun getById(@PathVariable id: Long): User =
        userService.findById(id)

    @PostMapping
    @Operation(summary = "Create new user")
    fun create(
        @Valid @RequestBody request: CreateUserRequest
    ): User =
        userService.create(request)

    @PutMapping("/{id}")
    @Operation(summary = "Update user")
    fun update(
        @PathVariable id: Long,
        @Valid @RequestBody request: CreateUserRequest
    ): User =
        userService.update(id, request)

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user")
    fun delete(@PathVariable id: Long) {
        userService.delete(id)
    }
}
