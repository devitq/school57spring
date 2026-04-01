package ru.tbank.education.school.lesson5.controller;

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v3/users")
class UserControllerV2() {
    @GetMapping("/{name}")
    fun get_v3(@PathVariable name: String): String {
        return "Hello, $name"
    }
}
