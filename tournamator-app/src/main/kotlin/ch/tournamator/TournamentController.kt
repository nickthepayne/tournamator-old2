package ch.tournamator

import ch.tournamator.data.Tournament
import ch.tournamator.data.TournamentRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TournamentController(val tournamentRepository: TournamentRepository) {

    @GetMapping("/tournaments")
    fun getTournaments() = tournamentRepository.findAll()

    @PostMapping("/tournaments")
    fun createTournament(@RequestBody request: CreateTournamentRequest) {
        val ( name ) = request
        tournamentRepository.save(Tournament(name))
    }

    data class CreateTournamentRequest(val name: String)
}
