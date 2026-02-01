package com.project.movienight.adapters.id

import com.project.movienight.application.ports.output.IdGenerator
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class UuidGenerator : IdGenerator {
    override fun generateId(): UUID = UUID.randomUUID()
}
