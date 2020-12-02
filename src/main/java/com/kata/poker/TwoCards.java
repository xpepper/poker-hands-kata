package com.kata.poker;

import java.util.Objects;

public class TwoCards {
    private final Card first;
    private final Card second;

    public TwoCards(Card first, Card second) {
        this.first = first;
        this.second = second;
    }

    public Card first() {
        return first;
    }

    public Card second() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TwoCards twoCards = (TwoCards) o;
        return Objects.equals(first, twoCards.first) && Objects.equals(second, twoCards.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
