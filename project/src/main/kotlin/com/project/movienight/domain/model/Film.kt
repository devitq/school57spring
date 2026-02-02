package com.project.movienight.domain.model

import java.util.UUID

data class Film(
    val id: UUID,
    var title: String,
    var description: String,
)
