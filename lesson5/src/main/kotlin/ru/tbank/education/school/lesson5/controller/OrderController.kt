package ru.tbank.education.school.lesson5.controller

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.tbank.education.school.lesson5.dto.CreateOrderRequest
import ru.tbank.education.school.lesson5.dto.Order
import ru.tbank.education.school.lesson5.service.OrderService

@RestController
@RequestMapping("/")
class OrderController(val orderService : OrderService) {
    @GetMapping("/list")
    fun list(): List<Order> {
        return orderService.list()
    }

    @PostMapping("/")
    fun create(@Valid @RequestBody order: CreateOrderRequest): Order {
        return orderService.create(order)
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): Order {
        return orderService.get(id)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @Valid @RequestBody order: CreateOrderRequest): Order {
        return orderService.update(id, order)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        orderService.delete(id)
    }
}
