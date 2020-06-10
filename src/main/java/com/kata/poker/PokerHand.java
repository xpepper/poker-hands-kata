package com.kata.poker;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.*;
import static java.util.Collections.sort;

public class PokerHand {

    private static final int WINNER = 1;
    private static final int LOSER = -1;

    private final List<Card> cards;

    public PokerHand(Card first, Card second) {
        this.cards = sortedListOf(first, second);
    }

    public HandOutcome playAgainst(PokerHand other) {
        int outcome = compareTo(other);
        switch (outcome) {
            case WINNER:
                return HandOutcome.Win;
            case LOSER:
                return HandOutcome.Lose;
            default:
                return HandOutcome.Tie;
        }
    }

    private int compareTo(PokerHand other) {
        if (hasStraightFlush() && other.hasStraightFlush()) {
            return compareHighestCard(other);
        }

        if (hasStraightFlush()) {
            return WINNER;
        }

        if (other.hasStraightFlush()) {
            return LOSER;
        }

        if (hasFlush() && other.hasFlush()) {
            return compareHighestCard(other);
        }

        if (hasFlush()) {
            return WINNER;
        }

        if (other.hasFlush()) {
            return LOSER;
        }

        if (hasStraight() && other.hasStraight()) {
            return compareHighestCard(other);
        }

        if (hasStraight()) {
            return WINNER;
        }

        if (other.hasStraight()) {
            return LOSER;
        }

        if (hasPair() && other.hasPair()) {
            return compareHighestCard(other);
        }

        if (hasPair()) {
            return WINNER;
        }

        if (other.hasPair()) {
            return LOSER;
        }

        return compareHighestCard(other);
    }

    private int compareHighestCard(PokerHand other) {
        return highestCard().compareTo(other.highestCard());
    }

    private boolean hasStraightFlush() {
        return hasStraight() && hasFlush();
    }

    private boolean hasFlush() {
        return cards.get(0).hasSameSuitOf(cards.get(1));
    }

    private boolean hasStraight() {
        return cards.get(0).comesBefore(cards.get(1));
    }

    private boolean hasPair() {
        return cards.get(0).hasSameValueOf(cards.get(1));
    }

    private Card highestCard() {
        return cards.get(1);
    }

    private List<Card> sortedListOf(Card first, Card second) {
        List<Card> cards = asList(first, second);
        sort(cards);
        return unmodifiableList(cards);
    }


}
