package ru.tbank.education.school.lesson2.spring

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ForeignBankPaymentConfiguration {

    @Bean
    fun vietnamBankPaymentProcessor() =
        object : PaymentProcessor {
            override fun process(amount: Long) {
                println("Обработали платеж суммой $amount через вьетнамский банк")
            }

        }
}