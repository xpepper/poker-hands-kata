package com.kata.poker;

public class Game {

    public static final String PLAYER_SEPARATOR = "  ";
    private final PlayerParser playerParser = new PlayerParser();

    private String rawGameInput;

    public Game(String rawGameInput) {
        this.rawGameInput = rawGameInput;
    }

    public String play() {
        GameResult gameResult = firstPlayer().playAgainst(secondPlayer());
        return new GameResultFormatter().format(gameResult);
    }

    private Player firstPlayer() {
        String rawFirstPlayer = rawGameInput.split(PLAYER_SEPARATOR)[0];
        return playerParser.parse(rawFirstPlayer);
    }

    private Player secondPlayer() {
        String rawSecondPlayer = rawGameInput.split(PLAYER_SEPARATOR)[1];
        return playerParser.parse(rawSecondPlayer);
    }

}
