package com.kata.poker;

class ThreeCards {
    private final Card first;
    private final Card second;
    private final Card third;

    public ThreeCards(Card first, Card second, Card third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public Card first() {
        return first;
    }

    public Card second() {
        return second;
    }

    public Card third() {
        return third;
    }
}
