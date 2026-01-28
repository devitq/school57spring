package ru.tbank.education.school.lesson2.spring

interface PaymentProcessor {
    fun process(amount: Long)
}