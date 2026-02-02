package com.project.movienight.application.ports.input

import com.project.movienight.domain.model.User
import java.util.UUID

interface CreateFilmUseCase {
    fun create(command: CreateFilmsUseCase): Film
}

data class CreateFilmCommand(
    val name: String,
    val genre: String,
    val description: String
)

interface UpdateFilmUseCase {
    fun update(
        id: UUID,
        command: UpdateFilmsCommand,
    )
}

data class UpdateFilmCommand(
    val name: String
)

interface DeleteFilmUseCase {
    fun delete(id: UUID)
}
