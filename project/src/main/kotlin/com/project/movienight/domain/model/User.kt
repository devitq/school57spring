package com.project.movienight.domain.model

import java.util.UUID

data class User(
    val id: UUID,
    var name: String,
    var email: String,
    val library: FilmLibrary?,
)
