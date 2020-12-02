package com.kata.poker;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TwoCards twoCards = (TwoCards) o;
        return Objects.equals(cards, twoCards.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards);
    }
}
