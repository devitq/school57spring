package com.project.movienight

import com.project.movienight.application.ports.input.CreateUserCommand
import com.project.movienight.application.services.UserService
import com.project.movienight.config.UserServiceProperties
import org.apache.catalina.startup.UserConfig
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class MovieNightService(
    private val userService: UserService,
    private val userConfig: UserServiceProperties,
) : CommandLineRunner {
    fun performActions() {
        println("Заблокированные имена пользователей: ${userConfig.blockedNames}")

        println("Создание пользователей...")
        val userAboba = userService.create(CreateUserCommand(name = "абоба", email = "aboba228@mail.com"))
        val userAlice = userService.create(CreateUserCommand(name = "алиса", email = "alice@mail.com"))
        val userBob = userService.create(CreateUserCommand(name = "боб", email = "bob@mail.com"))

        println(userAboba)
        println(userAlice)
        println(userBob)
    }

    override fun run(vararg args: String) {
        println("Запустился сервис")
        performActions()
    }
}
