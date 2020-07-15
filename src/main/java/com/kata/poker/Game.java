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
        String firstPlayerInput = input.split("  ")[0];
        String rawFirstPlayerHand = firstPlayerInput.split(": ")[1];
        PokerHand firstPlayerHand = pokerHandParser.parse(rawFirstPlayerHand);
        Player firstPlayer = new Player("Foo", firstPlayerHand);

        String secondPlayerInput = input.split("  ")[1];
        String secondPlayerName = secondPlayerInput.split(":")[0];
        String rawSecondPlayerHand = secondPlayerInput.split(": ")[1];
        PokerHand secondPlayerHand = pokerHandParser.parse(rawSecondPlayerHand);
        Player secondPlayer = new Player(secondPlayerName, secondPlayerHand);

        Winner winner = (Winner) secondPlayer.playAgainst(firstPlayer);

        return new GameResultPrinter().print(winner);
    }
}
