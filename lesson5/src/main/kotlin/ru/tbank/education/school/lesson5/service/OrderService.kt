package ru.tbank.education.school.lesson5.service

import org.springframework.stereotype.Service
import ru.tbank.education.school.lesson5.dto.CreateOrderRequest
import ru.tbank.education.school.lesson5.dto.Order

@Service
class OrderService {
    private val orders = mutableMapOf<Long, Order>()
    private var id = 1L

    fun get(id: Long): Order {
        return orders[id] ?: throw NoSuchElementException("order with this id not found")
    }

    fun list(): List<Order> {
        return orders.values.toList()
    }

    fun create(orderRequest: CreateOrderRequest): Order {
        val order = Order(id=++id, quantity=orderRequest.quantity)
        orders[order.id] = order
        return order
    }

    fun update(id: Long, newOrder: CreateOrderRequest): Order {
        orders[id] ?: throw NoSuchElementException("order with this id not found")
        val order = Order(id=id, quantity=newOrder.quantity)
        orders[id] = order
        return order
    }

    fun delete(id: Long) {
        orders.remove(id) ?: throw NoSuchElementException("order with this id not found")
    }
}
