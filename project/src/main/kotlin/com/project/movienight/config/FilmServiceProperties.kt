package com.project.movienight.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "services.film")
data class FilmServiceProperties(
    val blockedPatterns: List<String> = listOf(),
) {
    val normalized: Set<String> = blockedPatterns.map { it.trim().lowercase() }.toSet()

    fun isBlocked(fieldValue: String): Boolean {
        val fieldValue = fieldValue.lowercase()

        normalized.forEach { pattern ->
            if (fieldValue.contains(pattern)) {
                return true
            }
        }

        return false
    }
}
