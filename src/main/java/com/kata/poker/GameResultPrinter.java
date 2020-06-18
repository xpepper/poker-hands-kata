package com.kata.poker;

public class GameResultPrinter {
    public String print(Winner winner) {
        return winner.playerName() + " wins. - with " + print(winner.rank());
    }

    private String print(Rank rank) {
        switch (rank) {
            case Pair:
                return "pair";
            case HighCard:
                return "high card";
            default:
                throw new IllegalStateException("Unexpected value: " + rank);
        }

    }
}
