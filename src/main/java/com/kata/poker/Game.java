package com.kata.poker;

public class Game {

    private final PlayerParser playerParser = new PlayerParser();

    private String input;

    public Game(String input) {
        this.input = input;
    }

    public String play() {
        String firstPlayerInput = input.split("  ")[0];
        Player firstPlayer = playerParser.parse(firstPlayerInput);

        String secondPlayerInput = input.split("  ")[1];
        Player secondPlayer = playerParser.parse(secondPlayerInput);

        Winner winner = (Winner) secondPlayer.playAgainst(firstPlayer);

        return new GameResultPrinter().print(winner);
    }

}
