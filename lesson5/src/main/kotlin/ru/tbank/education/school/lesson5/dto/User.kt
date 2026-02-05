package ru.tbank.education.school.lesson5.dto

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class User(
    @JsonProperty("user_id")
    val id: Long,
    @NotBlank
    val name: String,
    @Email
    val email: String
)

