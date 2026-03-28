package com.project.movienight.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import java.util.Locale

@Component
@ConfigurationProperties(prefix = "services.film")
data class FilmServiceProperties(
    val blockedPatterns: List<String> = listOf(),
) {
    val normalized: Set<String> =
        blockedPatterns
            .map { it.trim().lowercase() }
            .filter { it.isNotBlank() }
            .toSet()

    fun isBlocked(fieldValue: String): Boolean {
        val normalizedFieldValue = fieldValue.lowercase(Locale.ROOT)

        return normalized.any { pattern -> normalizedFieldValue.contains(pattern) }
    }
}
