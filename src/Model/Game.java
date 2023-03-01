package Model;

import java.util.Vector;

import Model.Cards.*;

class Game {

    int m_numberOfPlayers;
    Vector <Card> FuanaCards;
    Vector<Integer> Scores;
    Vector <Player> players;
    Deck EarthDeck;
    Deck IslandDeck;
    Deck ClimateDeck;
    Deck FuanaDeck;
    Game(int numberOfPlayers)
    {   
        EarthDeck = new Deck();
        IslandDeck = new Deck();
        ClimateDeck = new Deck();
        FuanaDeck = new Deck();
        FuanaCards = new Vector<Card>();
        Scores = new Vector<Integer>();
        players = new Vector<Player>();
        m_numberOfPlayers = numberOfPlayers;
        // Game Setup Phase
        SetupPhase();
        


    }

    void SetupPhase()
    {
        EarthDeck.fillEarthDeck();
        ClimateDeck.fillClimateDeck();
        FuanaDeck.fillFuanaDeck();
        IslandDeck.fillIslandDeck();
        for (int i = 0; i < m_numberOfPlayers; i++)
        {
            players.add(new Player());
        }

        for (int j = 0; j<4; j++)
        {
            FuanaCards.add(FuanaDeck.dealCard());
        }
        // 1 Player game is standard expect everything to break
        for (int i = 0; i < m_numberOfPlayers; i++)
        {
            players.get(i).setIsland(IslandDeck.dealCard());
            players.get(i).setClimate(ClimateDeck.dealCard());
            // players.get(i).setEcosystem(EcosystemDeck.dealCard()); if we ever get here
        }
    }

    Vector<Card> getFuanaCards()
    {
        return FuanaCards;
    }

    Vector<Player> getPlayers()
    {
        return players;
    }
    //! Assumeing Solo Game

    // int numberOfPlayers;
    // Vector <Player> players;
    // Player firstPlayer; 
    
    void planting()
    {
        // Player Action
        // Plant 2 Cards
        // Draw 4 Discard 3 (not compost)
        
        // Gaia Action
        // Your Discards move to compost

        // Trigger Green Abilities
    }

    void compostion()
    {
        // Player Action
        // Gain 5 Soil
        // Compost 2 Cards from the EarthDeck

        // Gaia Action
        // Compost 2 cards, Compost 1 for every 2 soil gained this turn

        // Trugger Red and Multicolored Abilities
    }

    void watering()
    {
        //Player Action
        // Gain 6 sprouts
        // May gain 2 soul

        // Gaia Action
        // you gain 1 sprout per red ability you have

        // Trigger all blue and multicolored abilities
    }
    
    void growing()
    {
        // Player Action
        // Draw 4 to hand
        // Place 2 growth

        // Gaia Action
        // gain 1 growth for each draw this turn

        // Trigger Yellow and Multicolored Abilities
    }
}