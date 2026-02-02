package com.project.movienight.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "services.film")
data class FilmServiceProperties(
    val blockedNames: List<String> = listOf(),
) {
    private val normalized: Set<String> = blockedNames.map { it.trim().lowercase() }.toSet()

    fun isBlocked(name: String): Boolean = name.trim().lowercase() in normalized
}
