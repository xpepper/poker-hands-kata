package com.kata.poker;

public class GameRunner {

    public static final String PLAYER_SEPARATOR = "  ";

    private final PlayerParser playerParser;
    private final Game game;
    private final GameResultFormatter gameResultFormatter;

    public GameRunner() {
        playerParser = new PlayerParser();
        game = new Game(new GameRules());
        gameResultFormatter = new GameResultFormatter();
    }

    public String run(String rawGameInput) {
        GameResult gameResult = game.play(firstPlayer(rawGameInput), secondPlayer(rawGameInput));
        return gameResultFormatter.format(gameResult);
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
