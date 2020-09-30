package com.kata.poker;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

public class Hand {

    private final List<Card> cards;

    public Hand(Card first, Card second) {
        this.cards = sortedListOf(first, second);
    }

    public Card firstCard() {
        return cards.get(0);
    }

    public Card secondCard() {
        return cards.get(1);
    }

    public Card highestCard() {
        return cards.get(1);
    }

    private List<Card> sortedListOf(Card first, Card second) {
        List<Card> cards = asList(first, second);
        cards.sort(Card::compareTo);
        return unmodifiableList(cards);
    }

}
