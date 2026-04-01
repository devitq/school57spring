package ru.tbank.education.school.lesson5.dto

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive

data class Order(
    @field:JsonProperty("order_id")
    val id: Long,
    @field:Positive
    val quantity: Int
)
