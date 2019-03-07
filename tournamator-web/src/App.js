import React, { Component } from 'react';
import './App.scss';

class App extends Component {

    constructor(props) {
        super(props);

        this.state = {
            tournaments: [],
            inputValue: ''
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

    updateInputValue(evt) {
        const value = evt.target.value;
        this.setState(prev => ({...prev, inputValue: value}));
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
                    <p>
                        Tournamator
                    </p>

                    <div className="tournament-list">
                        {this.state.tournaments.map((tournament, i) => (
                            <div key={i}>{tournament.name}>Join</div>
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
