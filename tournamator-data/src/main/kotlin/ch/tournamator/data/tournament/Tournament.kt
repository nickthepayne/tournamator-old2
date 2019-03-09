package ch.tournamator.data.tournament

import ch.tournamator.data.BaseEntity
import org.springframework.data.mongodb.repository.MongoRepository

data class Tournament(
    val name: String,
    val discipline: String?
) : BaseEntity()

interface TournamentRepository : MongoRepository<Tournament, String>