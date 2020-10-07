package com.kata.poker;

import java.util.List;

import static java.util.Arrays.asList;

public class Hand {

    private final List<Card> cards;

    public Hand(Card... cards) {
        this.cards = sortedListOf(asList(cards));
    }

    public Card firstCard() {
        return cards.get(0);
    }

    public Card secondCard() {
        return cards.get(1);
    }

    public Card highestCard() {
        return cards.get(cards.size() - 1);
    }

    private List<Card> sortedListOf(List<Card> cards) {
        cards.sort(Card::compareTo);
        return cards;
    }

}
