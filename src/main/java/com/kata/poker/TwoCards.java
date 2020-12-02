package com.kata.poker;

import java.util.List;

public class TwoCards {
    private final List<Card> cards;

    public TwoCards(List<Card> cards) {
        this.cards = cards;
    }

    public Card first() {
        return cards.get(0);
    }

    public Card second() {
        return cards.get(1);
    }
}
