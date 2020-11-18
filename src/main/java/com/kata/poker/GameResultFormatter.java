package com.kata.poker;

import com.kata.poker.GameResult.Tie;
import com.kata.poker.Rank.*;

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
            return String.format("pair: %ss", formatCardValue(pair.value()));
        }
        if (rank instanceof ThreeOfKind) {
            ThreeOfKind threeOfKind = (ThreeOfKind) rank;
            return String.format("three of a kind: %ss", formatCardValue(threeOfKind.value()));
        }
        if (rank instanceof Straight) {
            Rank.Straight straight = (Straight) rank;
            return String.format("straight: %s-high", formatCardValue(straight.highestCardValue()));
        }
        if (rank instanceof Flush) {
            Flush flush = (Flush) rank;
            return String.format("flush: %s-high", formatCardValue(flush.highestCardValue()));
        }
        if (rank instanceof StraightFlush) {
            StraightFlush flush = (StraightFlush) rank;
            return String.format("straight flush: %s-high", formatCardValue(flush.highestCardValue()));
        }
        throw new IllegalStateException("Unexpected value: " + rank);
    }

    private String formatCardValue(Card.Value cardValue) {
        if (Ace.equals(cardValue)) {
            return "Ace";
        }
        if (cardValue.numericValue > 10) {
            throw new IllegalStateException("Unexpected card value: " + cardValue);
        }
        return cardValue.numericValue.toString();
    }
}
