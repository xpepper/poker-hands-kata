package com.kata.poker;

public class GameResultPrinter {

    public String print(GameResult gameResult) {
        if (gameResult instanceof GameResult.Tie) {
            return "Tie.";
        }

        Winner winner = (Winner) gameResult;
        return winner.playerName() + " wins. - with " + print(winner.rank());
    }

    private String print(Rank rank) {
        switch (rank) {
            case HighCard:
                return "high card";
            default:
                throw new IllegalStateException("Unexpected value: " + rank);
        }

    }
}
