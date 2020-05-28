package com.kata.poker;

public class Game {
    private static final int SECOND_PLAYER = -1;
    private static final int FIRST_PLAYER = 1;
    private static final int TIE = 0;

    private final Player firstPlayer;
    private final Player secondPlayer;

    public Game(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public String play() {
        int winningPlayer = firstPlayer.playAgainst(secondPlayer);
        switch (winningPlayer) {
            case FIRST_PLAYER:
                return firstPlayer.name + " wins. - with high card";
            case SECOND_PLAYER:
                return secondPlayer.name + " wins.";
            case TIE:
            default:
                return "Tie.";
        }
    }

}
