package com.kata.poker;

import java.util.List;

import static com.kata.poker.Outcome.*;
import static java.util.Arrays.asList;
import static java.util.Collections.*;
import static java.util.Collections.sort;

public class PokerHand {

    private final List<Card> cards;

    public PokerHand(Card first, Card second) {
        this.cards = sortedListOf(first, second);
    }

    public Outcome playAgainst(PokerHand other) {
        if (hasStraightFlush() && other.hasStraightFlush()) {
            return compareHighestCard(other);
        }

        if (hasStraightFlush()) {
            return Win;
        }

        if (other.hasStraightFlush()) {
            return Lose;
        }

        if (hasFlush() && other.hasFlush()) {
            return compareHighestCard(other);
        }

        if (hasFlush()) {
            return Win;
        }

        if (other.hasFlush()) {
            return Lose;
        }

        if (hasStraight() && other.hasStraight()) {
            return compareHighestCard(other);
        }

        if (hasStraight()) {
            return Win;
        }

        if (other.hasStraight()) {
            return Lose;
        }

        if (hasPair() && other.hasPair()) {
            return compareHighestCard(other);
        }

        if (hasPair()) {
            return Win;
        }

        if (other.hasPair()) {
            return Lose;
        }

        return compareHighestCard(other);
    }

    private Outcome compareHighestCard(PokerHand other) {
        return highestCard().playAgainst(other.highestCard());
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
