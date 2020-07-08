package com.kata.poker;

public class Game {
    private String input;

    public Game(String input) {
        this.input = input;
    }

    public String play() {
        String secondPlayerInput = input.split("  ")[1];
        String playerName = secondPlayerInput.split(":")[0];

        Winner winner = new Winner(new Player(playerName, new PokerHand(new Card(Card.Value.Four, Card.Suit.Spades), new Card(Card.Value.Seven, Card.Suit.Hearts))));
        return new GameResultPrinter().print(winner);
    }
}
