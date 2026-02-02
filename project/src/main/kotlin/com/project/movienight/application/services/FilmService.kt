package com.project.movienight.application.services

import com.project.movienight.application.ports.input.CreateFilmCommand
import com.project.movienight.application.ports.input.CreateFilmUseCase
import com.project.movienight.application.ports.input.DeleteFilmUseCase
import com.project.movienight.application.ports.input.EditFilmCommand
import com.project.movienight.application.ports.input.EditFilmUseCase
import com.project.movienight.application.ports.output.IdGenerator
import com.project.movienight.application.ports.output.FilmRepositoryPort
import com.project.movienight.config.FilmServiceProperties
import com.project.movienight.domain.model.Film
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class FilmService(
    private val FilmRepository: FilmRepositoryPort,
    private val idGenerator: IdGenerator,
    private val FilmConfig: FilmServiceProperties,
) : CreateFilmUseCase,
    EditFilmUseCase,
    DeleteFilmUseCase {
    override fun create(command: CreateFilmCommand): Film {
        if (FilmConfig.isBlocked(command.name)) {
            throw IllegalArgumentException("Film with this name is not acceptable")
        }

        val Film =
            Film(
                id = idGenerator.generateId(),
                name = command.name,
                email = command.email,
                library = null,
            )
        return FilmRepository.save(Film)
    }

    override fun edit(
        id: UUID,
        command: EditFilmCommand,
    ) {
        val Film = FilmRepository.findById(id) ?: throw IllegalArgumentException("Film with id $id not found")

        Film.name = command.name

        FilmRepository.save(Film)
    }

    override fun delete(id: UUID) {
        FilmRepository.findById(id) ?: throw IllegalArgumentException("Film with id $id not found")

        FilmRepository.deleteById(id)
    }
}
