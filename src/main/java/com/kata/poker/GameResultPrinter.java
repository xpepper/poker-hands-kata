package com.kata.poker;

public class GameResultPrinter {
    public String print(Winner winner) {
        return winner.playerName() + " wins. - with " + print(winner.rank());
    }

    private String print(Rank rank) {
        return "high card";
    }
}
