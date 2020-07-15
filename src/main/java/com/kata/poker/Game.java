package com.kata.poker;

import static com.kata.poker.Card.Suit.Clubs;
import static com.kata.poker.Card.Suit.Diamonds;
import static com.kata.poker.Card.Value.Four;
import static com.kata.poker.Card.Value.Two;

public class Game {

    private final PokerHandParser pokerHandParser = new PokerHandParser();

    private String input;

    public Game(String input) {
        this.input = input;
    }

    public String play() {
        String secondPlayerInput = input.split("  ")[1];
        String playerName = secondPlayerInput.split(":")[0];

        String rawSecondPlayerHand = secondPlayerInput.split(": ")[1];
        
        PokerHand firstPlayerHand = pokerHandParser.parse("2H 4D");
        PokerHand secondPlayerHand = pokerHandParser.parse(rawSecondPlayerHand);

        Player winnerPlayer = new Player(playerName, secondPlayerHand);
        Player alwaysLoosingPlayer = new Player("Foo", firstPlayerHand);
        Winner winner = (Winner) winnerPlayer.playAgainst(alwaysLoosingPlayer);

        return new GameResultPrinter().print(winner);
    }
}
