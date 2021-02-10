package com.kata.poker;

import com.kata.poker.GameResult.Tie;

public class GameResultFormatter {

    private final RankFormatter rankFormatter;

    public GameResultFormatter() {
        rankFormatter = new RankFormatter();
    }

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
        return String.format("%s wins. - with %s", winner.playerName(), rankMessage(winner.rank()));
    }

    private String rankMessage(Rank rank) {
        return rank.displayUsing(rankFormatter);
    }

}
