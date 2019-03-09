import React, { Component } from 'react';
import './App.scss';

class App extends Component {

    constructor(props) {
        super(props);

        this.state = {
            tournaments: [],
            inputValue: '',
            disabledTournaments: []
        };

    }

    async componentDidMount() {
        this.getTournaments();
    }

    async getTournaments() {
        const response = await fetch('/tournaments');
        const tournaments = await response.json();

        this.setState(prev => ({
            ...prev,
            tournaments
        }));
    }

    async createTournament() {
        await this.doCreateTournament(this.state.inputValue);

        this.getTournaments();
    }

    async deleteTournament(tournament) {
        this.setDisabled(tournament.id);

        try {
            await fetch(`/tournaments/${tournament.id}`, {
                method: 'DELETE',
            });

            this.setState(prev => ({
                ...prev,
                tournaments: prev.tournaments.filter(t => t.id !== tournament.id)
            }));
        } catch (e) {
            console.error(e);
            this.unsetDisabled(tournament.id);
        }
    }

    setDisabled(tournamentId) {
        this.setState(prev => ({
            ...prev,
            disabledTournaments: [...prev.disabledTournaments, tournamentId]
        }))
    }

    unsetDisabled(tournamentId) {
        this.setState(prev => ({
            ...prev,
            disabledTournaments: prev.disabledTournaments.filter(t => t.id !== tournamentId)
        }))
    }

    updateInputValue(evt) {
        const value = evt.target.value;
        this.setState(prev => ({ ...prev, inputValue: value }));
    }

    async doCreateTournament(name) {
        return await fetch('/tournaments', {
            method: 'POST',
            body: JSON.stringify({ name }),
            headers: {
                'Content-Type': 'application/json'
            }
        });
    }

    render() {
        return (
            <div className="App">
                <header className="App-header">
                    <h2>Tournamator</h2>


                    <p>Tournaments</p>
                    <div className="tournament-list">
                        {this.state.tournaments.map((tournament, i) => (
                            <div key={i} className={`tournament ${this.state.disabledTournaments.includes(tournament.id) ? 'disabled' : ''}`}>
                                <div className="tournament-discipline" key={i}>Tennis</div>
                                <div className="tournament-name" key={tournament.name}>
                                    <div>{tournament.name}</div>
                                    <div className="delete-tournament" onClick={() => this.deleteTournament(tournament)}>x</div>
                                </div>
                            </div>
                        ))}
                    </div>

                    <input type="text" placeholder="Name" onChange={evt => this.updateInputValue(evt)}/>
                    <button onClick={() => this.createTournament()}>Create new Tournament</button>
                </header>
            </div>
        );
    }
}

export default App;
