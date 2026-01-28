package ru.tbank.education.school.lesson2.spring

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PaymentProcessorConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "payment.mir")
    fun mirPaymentProperties() = PaymentProcessorProperties()

    @Bean
    @ConfigurationProperties(prefix = "payment.crypto")
    fun cryptoPaymentProperties() = PaymentProcessorProperties()

    @Bean
    @ConditionalOnProperty(prefix = "payment", name = ["type"], havingValue = "MIR", matchIfMissing = true)
    fun mirPaymentService(
        mirPaymentProcessor: MirPaymentProcessor,
        @Value("\${payment.amount}")
        amount: Long
    ) = PaymentService(mirPaymentProcessor, amount)

    @Bean
    @ConditionalOnProperty(prefix = "payment", name = ["type"], havingValue = "CRYPTO")
    fun cryptoPaymentService(
        cryptoPaymentProcessor: CryptoPaymentProcessor,
        @Value("\${payment.amount}")
        amount: Long
    ) = PaymentService(cryptoPaymentProcessor, amount)
}