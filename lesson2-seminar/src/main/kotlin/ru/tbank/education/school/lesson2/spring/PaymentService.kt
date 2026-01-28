package ru.tbank.education.school.lesson2.spring

import org.springframework.boot.CommandLineRunner

class PaymentService(
    private val paymentProcessor: PaymentProcessor,
    private val amount: Long
) : CommandLineRunner {

    fun processPayment(amount: Long) {
        println("Обрабатываем платеж")
        paymentProcessor.process(amount)
    }

    override fun run(vararg args: String?) {
        println("Запустился сервис платежей")
        processPayment(amount)
    }
}