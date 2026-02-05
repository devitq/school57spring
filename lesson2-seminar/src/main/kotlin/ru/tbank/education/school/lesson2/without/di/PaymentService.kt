package ru.tbank.education.school.lesson2.without.di

class PaymentService {
    private val processor = MirPaymentProcessor()
    private val sbpProcessor = SbpPaymentProcessor()

    fun processPayment(amount: Long) {
        println("Обрабатываем платеж")
        sbpProcessor.process(amount)
    }
}

class MirPaymentProcessor {
    fun process(amount: Long) {
        println("Платеж суммой $amount совершен по карте МИР")
    }
}

class SbpPaymentProcessor {
    fun process(amount: Long) {
        println("Платеж суммой $amount совершен по СБП")
    }
}

// spring require single main class
//fun main() {
//    val paymentService = PaymentService()
//    paymentService.processPayment(1000)
//}