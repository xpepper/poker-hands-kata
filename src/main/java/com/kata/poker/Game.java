package com.kata.poker;

public class Game {

    private final CardParser cardParser = new CardParser();

    private String input;

    public Game(String input) {
        this.input = input;
    }

    public String play() {
        String secondPlayerInput = input.split("  ")[1];
        String playerName = secondPlayerInput.split(":")[0];

        String[] rawPlayerHand = secondPlayerInput.split(": ")[1].split(" ");
        Card firstCard = cardParser.parse(rawPlayerHand[0]);
        Card secondCard = cardParser.parse(rawPlayerHand[1]);
        PokerHand hand = new PokerHand(firstCard, secondCard);

        Winner winner = new Winner(new Player(playerName, hand));
        return new GameResultPrinter().print(winner);
    }

}
