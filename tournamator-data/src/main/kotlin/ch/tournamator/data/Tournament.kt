package ch.tournamator.data

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.repository.MongoRepository
import javax.annotation.Generated

data class Tournament(val name: String)

    @Id
    @Generated
    var id: String? = null


interface TournamentRepository : MongoRepository<Tournament, String>