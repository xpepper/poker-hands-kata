package com.kata.poker;

import com.kata.poker.GameResult.Tie;

public class GameResultFormatter {

    public String format(GameResult result) {
        if (result instanceof Tie) {
            return tieMessage();
        }

        return winnerMessage((Winner) result);
    }

    private String tieMessage() {
        return "Tie.";
    }

    private String winnerMessage(Winner winner) {
        return winner.playerName() + " wins. - with " + rankMessage(winner.rank()) + ": 7";
    }

    private String rankMessage(Rank rank) {
        switch (rank) {
            case HighCard:
                return "high card";
            default:
                throw new IllegalStateException("Unexpected value: " + rank);
        }
    }
}
