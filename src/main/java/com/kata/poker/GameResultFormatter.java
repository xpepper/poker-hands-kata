package com.kata.poker;

import com.kata.poker.GameResult.Tie;

import static com.kata.poker.Card.Suit.Hearts;
import static com.kata.poker.Card.Value.Seven;

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
        return winner.playerName() + " wins. - with " + rankMessage(winner.rank()) + ": " + pointMessage();
    }

    private String pointMessage() {
        Card highestCard = new Card(Seven, Hearts);
        return cardMessage(highestCard);
    }

    private String cardMessage(Card card) {
        switch (card.value) {
            case Seven:
                return "7";
            default:
                throw new IllegalStateException("Unexpected value: " + card);
        }
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
