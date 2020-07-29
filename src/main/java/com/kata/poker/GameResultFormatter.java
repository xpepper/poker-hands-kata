package com.kata.poker;

import com.kata.poker.GameResult.Tie;
import com.kata.poker.Rank.HighCard;

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
        return winner.playerName() + " wins. - with " + rankMessage(winner.rank());
    }

    private String rankMessage(Rank rank) {
        if (rank instanceof HighCard) {
            HighCard highCard = (HighCard) rank;
            return "high card: "+ highCard.value().numericValue;
        }
        throw new IllegalStateException("Unexpected value: " + rank);
    }
}
