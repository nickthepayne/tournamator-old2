package ch.tournamator.data

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.repository.MongoRepository

data class Tournament(val name: String) {

    @Id
    var id: String? = null

}


interface TournamentRepository : MongoRepository<Tournament, String>