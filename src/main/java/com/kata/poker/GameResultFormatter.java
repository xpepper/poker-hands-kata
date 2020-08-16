package com.kata.poker;

import com.kata.poker.GameResult.Tie;
import com.kata.poker.Rank.Flush;
import com.kata.poker.Rank.HighCard;
import com.kata.poker.Rank.Pair;
import com.kata.poker.Rank.StraightFlush;

import static com.kata.poker.Card.Value.Ace;
import static com.kata.poker.Rank.Straight;

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
        return String.format("%s wins. - with %s", winner.playerName(), rankMessage(winner.rank()));
    }

    private String rankMessage(Rank rank) {
        if (rank instanceof HighCard) {
            HighCard highCard = (HighCard) rank;
            return String.format("high card: %s", formatCardValue(highCard.value()));
        }
        if (rank instanceof Pair) {
            Pair pair = (Pair) rank;
            return String.format("pair: %ds", pair.value().numericValue);
        }
        if (rank instanceof Straight) {
            Rank.Straight straight = (Straight) rank;
            return String.format("straight: %d-high", straight.highestCardValue().numericValue);
        }
        if (rank instanceof Flush) {
            Flush flush = (Flush) rank;
            return String.format("flush: %d-high", flush.highestCardValue().numericValue);
        }
        if (rank instanceof StraightFlush) {
            StraightFlush flush = (StraightFlush) rank;
            return String.format("straight flush: %d-high", flush.highestCardValue().numericValue);
        }
        throw new IllegalStateException("Unexpected value: " + rank);
    }

    private String formatCardValue(Card.Value cardValue) {
        if (Ace.equals(cardValue)) {
            return "Ace";
        }
        return cardValue.numericValue.toString();
    }
}
