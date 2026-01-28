package ru.tbank.education.school.lesson2.spring

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
class CryptoPaymentProcessor(
    @Qualifier("cryptoPaymentProperties")
    private val paymentProcessorProperties: PaymentProcessorProperties
) : PaymentProcessor {
    override fun process(amount: Long) {
        if (amount < paymentProcessorProperties.minAmount)
            println("Минимальная сумма платежа - ${paymentProcessorProperties.minAmount} ${paymentProcessorProperties.currency}")
        else if (amount > paymentProcessorProperties.maxAmount)
            println("Макс. сумма платежа - ${paymentProcessorProperties.maxAmount} ${paymentProcessorProperties.currency}")
        else {
            println("Обработали платеж суммой $amount ${paymentProcessorProperties.currency} через крипту")
            println("Коммисия за платеж - ${amount * paymentProcessorProperties.fee}")
        }

    }

}