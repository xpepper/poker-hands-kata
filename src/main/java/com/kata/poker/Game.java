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
        Player firstPlayer = parsePlayer(firstPlayerInput);

        String secondPlayerInput = input.split("  ")[1];
        Player secondPlayer = parsePlayer(secondPlayerInput);

        Winner winner = (Winner) secondPlayer.playAgainst(firstPlayer);

        return new GameResultPrinter().print(winner);
    }

    private Player parsePlayer(String rawPlayer) {
        String name = rawPlayer.split(":")[0];
        String rawPokerHand = rawPlayer.split(": ")[1];
        PokerHand pokerHand = pokerHandParser.parse(rawPokerHand);
        return new Player(name, pokerHand);
    }
}
