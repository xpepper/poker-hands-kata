package com.kata.poker;

public class FourCards {
    private final Card first;
    private final Card second;
    private final Card third;
    private final Card fourth;

    public FourCards(Card first, Card second, Card third, Card fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    public Card first() {
        return first;
    }
}
