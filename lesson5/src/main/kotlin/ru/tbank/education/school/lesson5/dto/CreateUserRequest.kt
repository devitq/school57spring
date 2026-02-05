package ru.tbank.education.school.lesson5.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class CreateUserRequest(
    @field:NotBlank
    val name: String,

    @field:Email
    val email: String
)

