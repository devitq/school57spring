package ru.tbank.education.school.lesson5.dto

import jakarta.validation.constraints.Positive

class CreateOrderRequest(
    @field:Positive
    val quantity: Int
)
