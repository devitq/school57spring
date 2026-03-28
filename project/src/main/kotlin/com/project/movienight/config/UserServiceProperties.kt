package com.project.movienight.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import java.util.Locale

@Component
@ConfigurationProperties(prefix = "services.user")
data class UserServiceProperties(
    val blockedNames: List<String> = listOf(),
) {
    private val normalized: Set<String> = blockedNames.map { it.trim().lowercase() }.toSet()

    fun isBlocked(name: String): Boolean = name.trim().lowercase(Locale.ROOT) in normalized
}
