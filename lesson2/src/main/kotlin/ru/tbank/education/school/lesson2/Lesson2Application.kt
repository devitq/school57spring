package ru.tbank.education.school.lesson2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import ru.tbank.education.school.lesson2.examples.AppInfoProperties

@SpringBootApplication
@EnableConfigurationProperties(AppInfoProperties::class)
class Lesson2Application

fun main(args: Array<String>) {
	runApplication<Lesson2Application>(*args)
}
