package com.kata.poker;

public class Game {

    private final PlayerParser playerParser = new PlayerParser();

    private String input;

    public Game(String input) {
        this.input = input;
    }

    public String play() {
        Winner winner = (Winner) secondPlayer().playAgainst(firstPlayer());

        return new GameResultPrinter().print(winner);
    }

    private Player firstPlayer() {
        String firstPlayerInput = input.split("  ")[0];
        return playerParser.parse(firstPlayerInput);
    }

    private Player secondPlayer() {
        String secondPlayerInput = input.split("  ")[1];
        return playerParser.parse(secondPlayerInput);
    }

}
