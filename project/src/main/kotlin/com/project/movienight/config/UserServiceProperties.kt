package com.project.movienight.config

import org.springframework.boot.context.properties.ConfigurationProperties
import java.util.Locale

@ConfigurationProperties(prefix = "services.user")
data class UserServiceProperties(
    val blockedNames: List<String> = listOf(),
) {
    private val normalized: Set<String> = blockedNames.map { it.trim().lowercase() }.toSet()

    fun isBlocked(name: String): Boolean = name.trim().lowercase(Locale.ROOT) in normalized
}
