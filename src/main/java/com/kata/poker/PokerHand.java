package com.kata.poker;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.*;
import static java.util.Collections.sort;

public class PokerHand implements Comparable<PokerHand> {

    private final List<Card> cards;

    public PokerHand(Card first, Card second) {
        this.cards = sortedListOf(first, second);
    }

    @Override
    public int compareTo(PokerHand other) {
        if (hasFlush() && other.hasFlush()) {
            return highestCard().compareTo(other.highestCard());
        }

        if (hasFlush()) {
            return 1;
        }

        if (other.hasFlush()) {
            return -1;
        }

        if (hasStraight() && other.hasStraight()) {
            return highestCard().compareTo(other.highestCard());
        }

        if (hasStraight()) {
            return 1;
        }

        if (other.hasStraight()) {
            return -1;
        }

        if (hasPair() && other.hasPair()) {
            return highestCard().compareTo(other.highestCard());
        }

        if (hasPair()) {
            return 1;
        }

        if (other.hasPair()) {
            return -1;
        }

        return highestCard().compareTo(other.highestCard());
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
