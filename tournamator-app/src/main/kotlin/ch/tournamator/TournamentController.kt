package ch.tournamator

import ch.tournamator.data.tournament.Tournament
import ch.tournamator.data.tournament.TournamentRepository
import org.springframework.web.bind.annotation.*

@RestController
class TournamentController(val tournamentRepository: TournamentRepository) {

    @GetMapping("/tournaments")
    fun getTournaments(): MutableList<Tournament> = tournamentRepository.findAll()

    @PostMapping("/tournaments")
    fun createTournament(@RequestBody tournament: Tournament) {
        tournamentRepository.save(tournament)
    }

    @DeleteMapping("/tournaments/{id}")
    fun deleteTournament(@PathVariable id: String) {
        Thread.sleep(2000)
        tournamentRepository.deleteById(id)
    }

}
