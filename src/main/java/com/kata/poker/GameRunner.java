package com.kata.poker;

public class GameRunner {

    public static final String PLAYER_SEPARATOR = "  ";

    private final PlayerParser playerParser = new PlayerParser();
    private final Game game = new Game(new GameRules());

    public GameRunner() {
    }

    public String run(String rawGameInput) {
        GameResult gameResult = game.play(firstPlayer(rawGameInput), secondPlayer(rawGameInput));
        return new GameResultFormatter().format(gameResult);
    }

    private Player firstPlayer(String rawGameInput) {
        String rawFirstPlayer = rawGameInput.split(PLAYER_SEPARATOR)[0];
        return playerParser.parse(rawFirstPlayer);
    }

    private Player secondPlayer(String rawGameInput) {
        String rawSecondPlayer = rawGameInput.split(PLAYER_SEPARATOR)[1];
        return playerParser.parse(rawSecondPlayer);
    }

}
