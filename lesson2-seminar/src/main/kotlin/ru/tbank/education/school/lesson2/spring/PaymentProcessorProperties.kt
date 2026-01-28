package ru.tbank.education.school.lesson2.spring


data class PaymentProcessorProperties(
    var fee: Double = 0.1,
    var minAmount: Long = 10,
    var maxAmount: Long = 100,
    var currency: String = "USD"
)