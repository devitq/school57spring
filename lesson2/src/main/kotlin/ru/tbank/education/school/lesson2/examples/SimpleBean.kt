package ru.tbank.education.school.lesson2.examples

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class SimpleBean : CommandLineRunner {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun run(vararg args: String?) {
        log.info("SimpleBean в ApplicationContext")
    }
}